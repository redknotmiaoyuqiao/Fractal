//
// Created by redknot on 18-8-22.
//
#include "GLPaint.hpp"

GLLine::GLLine(float startX,float startY,float endX,float endY,DrawCall * lineDrawCall)
{
    this->lineDrawCall = lineDrawCall;
    this->startX = startX;
    this->startY = startY;
    this->endX = endX;
    this->endY = endY;
}

GLLine::~GLLine()
{

}

void GLLine::SetColor(float r,float g,float b)
{

}

void GLLine::Draw()
{

}
