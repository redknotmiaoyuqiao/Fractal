add_library(
        julia-lib SHARED
        Interface.cpp
)

include_directories (../)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

find_library(log-lib log)

target_link_libraries (julia-lib redlib)
target_link_libraries (julia-lib hstgl)


