#include "RedLib/RedLib.h"
#include <sys/time.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <time.h>

long long getSystemTime()
{

    struct timeval tv;
    gettimeofday(&tv,NULL);    //该函数在sys/time.h头文件中
    return tv.tv_sec * 1000 + tv.tv_usec / 1000;
}

void * RedMalloc(size_t size)
{
    return malloc(size);
}

void RedFree(void * point){
    free(point);
}

unsigned int RedRand()
{
    return (unsigned int)rand();
}


char * getRandomString(int length)
{
	int flag, i;
	char * string;
	//srand((unsigned) time(NULL));
	if ((string = (char *)malloc(length)) == NULL )
	{
		return NULL ;
	}
 
	for (i = 0; i < length - 1; i++)
	{
		flag = rand() % 3;
		switch (flag)
		{
			case 0:
				string[i] = 'A' + rand() % 26;
				break;
			case 1:
				string[i] = 'a' + rand() % 26;
				break;
			case 2:
				string[i] = '0' + rand() % 10;
				break;
			default:
				string[i] = 'x';
				break;
		}
	}
	string[length - 1] = '\0';
	return string;
}