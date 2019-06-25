//
// Created by redknot on 18-8-22.
//

#ifndef SXAUFACE_GLPAINT_H
#define SXAUFACE_GLPAINT_H

#include "HstGL/RedGL.hpp"

class GLLine{
public:
    float startX;
    float startY;
    float endX;
    float endY;

    DrawCall * lineDrawCall = NULL;

    GLLine(float startX,float startY,float endX,float endY,DrawCall * lineDrawCall);
    ~GLLine();

    void SetColor(float r,float g,float b);

    void Draw();
};

#endif //SXAUFACE_GLPAINT_H
