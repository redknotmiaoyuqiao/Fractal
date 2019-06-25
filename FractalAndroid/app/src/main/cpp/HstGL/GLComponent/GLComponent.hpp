#ifndef SXAUFACE_GLCOMPONENT_H
#define SXAUFACE_GLCOMPONENT_H

#include "../GL.hpp"
#include "../GLProgram/GLProgram.hpp"
#include "HstGL/RedGL.hpp"

#define TARGET_SCREEN 1
#define TARGET_FRAMEBUFFER 2

class DrawCall;

class DrawCall{
private:
public:
    GLProgram * program = NULL;
    GLVAO * vao = NULL;

    GLuint frameBuffer = 0;

    int renderWidth = 0;
    int renderHeight = 0;

    int target = TARGET_SCREEN;

    GLTexture * texture = NULL;

    DrawCall(char * vertex, char * fragment,int renderWidth,int renderHeight,int target=TARGET_SCREEN);
    ~DrawCall();

    void SetVAO(GLVAO * vao);

    void Draw();

    ////Uniform
    void UniformInteger(char * uniform, int v);
    void UniformFloat(char * uniform, float v);
    void UniformMatrix4fv(char * uniform, float * mat);

    void BindFrameBuffer();
    GLTexture * getTexture();
};

#endif //SXAUFACE_GLCOMPONENT_H
