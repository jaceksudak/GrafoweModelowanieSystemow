#include <stdio.h>
#include <stdlib.h>


/*
	program sluzy do testowania poprawnosci rozwiazania.
	deskryptory:
		stdin - dane testowe (usostepniony plik)
		3 - wyjscie programu uzytkownika
		6 - ewentualne komunikaty o bledach (brak komuniktow ==> wyjscie poprawne)

przyklad uzycia:
	./judge <in 3<out 6>&1
brak jakichkolwiek komunikatow oznacza, ze rozwiazanie, które znajduje sie w pliku out jest poprawne
(dane testowe są w pliku in, a deskryptor 6 jest przekierowany na standardowe wyjscie)
*/

#define MAX 600

int m[MAX][MAX];
int w[MAX][MAX];

int m_married_to[MAX]; // i-ty mezcz. ma za zone m_married_to[i], lub -1 gdy wolny
int w_married_to[MAX]; // j.w.

int w_rating[MAX][MAX]; // w_rating[i][j]=k - j-ty m. jest k-ty na liscie kobiety i
int m_rating[MAX][MAX]; // w_rating[i][j]=k - j-ty m. jest k-ty na liscie kobiety i

void Init( int size ) {
  int i, j;

  for ( i=0; i < size; i++ ) {
    for ( j=0; j < size; j++ ) {
      w_rating[i][w[i][j]] = j;
      m_rating[i][m[i][j]] = j;
    }
  }
}


void ReadPerm( FILE *file, int n, int p[MAX][MAX], int r ) {
  int i, tmp;

  for ( i=0; i < n; i++ ) {
    fscanf( file, "%d", &tmp );
    p[r][i] = tmp;
    p[r][i]--;
  }
}

int ReadTestCase( FILE *file ) {
  int size;
  int i, tmp;

  fscanf( file, "%d", &size );

  for ( i=0; i < size; i++ ) {
    fscanf( file, "%d", &tmp );

    ReadPerm( file, size, w, i );
  }

  for ( i=0; i < size; i++ ) {
    fscanf( file, "%d", &tmp );
    ReadPerm( file, size, m, i );
  }
  return size;
}


void ReadUserOutput( FILE *fd, int size ) {
  int i, m_, f_;
  for ( i=0; i < size; i++ ) {
    if ( fscanf( fd, "%d", &m_ ) == 0 )
      exit(1);
    if ( fscanf( fd, "%d", &f_ ) == 0 )
      exit(1);
    m_married_to[m_-1] = f_ - 1;
    w_married_to[f_-1] = m_ - 1;
  }
}


void CheckSol( int size ) {
  int i, j, fi, fj, fir;

  Init( size );
  //    PrintData( size );

  for ( i=0; i < size; i++ ) {
    fi = m_married_to[i];
    if ( fi == -1 ) {
      fprintf( stderr, "some man is not married...\n" );
      exit(1);
    }
    if ( fi < 0 || fi >= size ){
      fprintf( stderr, "wrong range...\n" );
      exit(1);
    }
    fir = w_rating[fi][i];
    for ( j=0; j < size; j++ ) {
      fj = m_married_to[j];
      if ( fj < 0 || fj >= size ){
        fprintf( stderr, "wrong range...\n" );
        exit(1);
      }
      if ( i != j ) {
		if ( w_rating[fi][j] < fir && m_rating[j][fi] < m_rating[j][fj] ) {
		  fprintf( stderr, "not stable: (%d,%d),(%d,%d)\n",i+1,fi+1,j+1,fj+1 );
		  exit(1);
		}
		if ( fi == fj ) {
		  fprintf( stderr, "some woman has many husbands...\n" );
		  exit(1);
		}
      }
    }
  }
}


void PrintData( int size ) {
  int i, j;

  for ( i=0; i < size; i++ )
    printf( "%d %d\n", i+1, m_married_to[i]+1 );

  printf( "w = \n" );
  for ( i=0; i < size; i++ ) {
    for ( j=0; j < size; j++ )
      printf( "%d ", w_rating[i][j] );
    putchar( '\n' );
  }

  printf( "m = \n" );
  for ( i=0; i < size; i++ ) {
    for ( j=0; j < size; j++ )
      printf( "%d ", m_rating[i][j] );
    putchar( '\n' );
  }

}


main() {
  int t, size;
  FILE *uout = fdopen( 3, "r" );

  if ( uout == NULL )
    printf( "error opening file\n" );

  scanf( "%d", &t );
  while ( t-- ) {
    size = ReadTestCase( stdin );
    ReadUserOutput( uout, size );
    CheckSol( size );
  }
  return 0;
}
