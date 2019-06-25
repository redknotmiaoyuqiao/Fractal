#include "com_redknot_julia_JuliaJNI.h"
#include <HstGL/RedGL.hpp>
#include "RedLib/Debug.h"

GLfloat vertices[] = {
        1.0f, 1.0, 0.0f,   // 右上角
        1.0f, -1.0f, 0.0f,  // 右下角
        -1.0f, -1.0f, 0.0f, // 左下角
        -1.0f, 1.0f, 0.0f   // 左上角
};

GLuint indices[] = {
        0, 1, 3, // 第一个三角形
        1, 2, 3  // 第二个三角形
};

GLfloat txtcoor[] = {
        1.0f, 1.0, 0.0f,   // 右上角
        1.0f, 0.0f, 0.0f,  // 右下角
        0.0f, 0.0f, 0.0f, // 左下角
        0.0f, 1.0f, 0.0f   // 左上角
};

DrawCall * drawCall = NULL;

float _width;
float _height;

JNIEXPORT void JNICALL Java_com_redknot_julia_JuliaJNI_CreateJulia
(JNIEnv *, jclass, jint width, jint height)
{
    _width = width * 1.0f;
    _height = height * 1.0f;
    RedLog("---Width:%d\n",width);
    RedLog("---Height:%d\n",height);

    GLVAO * vao = new GLVAO();

    vao->AddVBO(vertices,sizeof(vertices),0,3);
    vao->AddVBO(txtcoor,sizeof(txtcoor),1,3);
    vao->SetEBO(indices,sizeof(indices));

    drawCall = new DrawCall((char *)Julia_Vertex_Shader,(char *)Julia_Fragment_Shader,width,height,TARGET_SCREEN);
    drawCall->SetVAO(vao);

    glClearColor(1.0f,1.0f,0.0f,1.0f);
}

float iTime = 0.0f;

JNIEXPORT void JNICALL Java_com_redknot_julia_JuliaJNI_CreateOnFrame
(JNIEnv *, jclass)
{
    glClear(GL_COLOR_BUFFER_BIT);
    //渲染
    drawCall->UniformFloat((char *)"iTime",iTime);
    drawCall->UniformFloat((char *)"width",_width);
    drawCall->UniformFloat((char *)"height",_height);
    drawCall->Draw();

    iTime += 0.002;
}