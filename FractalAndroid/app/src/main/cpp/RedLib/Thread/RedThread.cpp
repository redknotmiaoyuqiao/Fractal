#include "RedLib/RedLib.h"

#include <thread>

#include <unistd.h>
#include <functional>

void RedThread::detach()
{
    //std::bind(&Test::print,this);
    //std::thread t(&RedThread::run,this);

    std::thread t(std::bind(&RedThread::run,this));

    t.detach();
}

void RedThread::join()
{
    //std::thread t(&RedThread::run,this);

    std::thread t(std::bind(&RedThread::run,this));
    t.join();
}


int RedThread::isRunning()
{
    return 1;
}
