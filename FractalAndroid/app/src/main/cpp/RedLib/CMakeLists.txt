include_directories (./)
include_directories (../)

add_library(
        redlib

        RedLib.h
        RedLib.cpp
        Thread/RedThread.cpp

        Debug.h
	)


find_package(Threads)

find_library(log-lib log)

target_link_libraries (redlib ${CMAKE_THREAD_LIBS_INIT})
target_link_libraries (redlib ${log-lib})

