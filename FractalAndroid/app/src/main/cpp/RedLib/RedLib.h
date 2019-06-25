#ifndef	RED_THREAD_H
#define	RED_THREAD_H

#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>

class RedThread
{
public:
    virtual void run() = 0;

    int isRunning();
    void detach();
    void join();
};

class RedThreadPool
{
public:
};

#ifdef	__cplusplus
extern	"C" {
#endif

void * RedMalloc(size_t size);

void RedFree(void * point);

long long getSystemTime();

unsigned int RedRand();

char * getRandomString(int length);

#ifdef	__cplusplus
}
#endif

#endif
