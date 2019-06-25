add_library(
    hstgl
    RedGL.hpp
    GL.hpp

    GLPaint/GLPaint.hpp
    GLPaint/GLLine.cpp

    GLProgram/GLProgram.hpp
    GLProgram/GLProgram.cpp
    GLProgram/GLShader.cpp

    GLVAO/GLVAO.hpp
    GLVAO/GLVAO.cpp

    GLTexture/GLTexture.hpp
    GLTexture/GLTexture.cpp

    GLComponent/GLComponent.hpp
    GLComponent/DrawCall.cpp
    GLComponent/Render.cpp

    IMAGE/stb_image.cpp
    IMAGE/stb_image.h
    IMAGE/file.hpp
    IMAGE/ImageFile.cpp
    )

include_directories (../)
include_directories (./)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

find_package(Threads)

target_link_libraries (hstgl ${CMAKE_THREAD_LIBS_INIT})

target_link_libraries(hstgl
                        GLESv3)

target_link_libraries(
                       hstgl
                       ${log-lib})