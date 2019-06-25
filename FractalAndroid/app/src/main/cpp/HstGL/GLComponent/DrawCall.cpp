//
// Created by redknot on 18-8-22.
//

#include <HstGL/RedGL.hpp>
#include <RedLib/Debug.h>
#include "GLComponent.hpp"

DrawCall::DrawCall(char * vertex, char * fragment,int renderWidth,int renderHeight,int target)
{
    this->target = target;

    this->renderWidth = renderWidth;
    this->renderHeight = renderHeight;

    GLShader * v_shader = new GLShader(GL_VERTEX_SHADER,vertex);
    GLShader * f_shader = new GLShader(GL_FRAGMENT_SHADER,fragment);

    program = new GLProgram();
    program->AddShader(v_shader);
    program->AddShader(f_shader);
    program->LinkProgram();

    if(this->target == TARGET_SCREEN){
        frameBuffer = 0;
    }
    else if(this->target == TARGET_FRAMEBUFFER){
        glGenFramebuffers(1,&frameBuffer);
        glBindFramebuffer(GL_FRAMEBUFFER,frameBuffer);

        texture = new GLTexture();
        // 生成纹理
        glBindTexture(GL_TEXTURE_2D, texture->TextureId);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, this->renderWidth, this->renderHeight, 0, GL_RGB, GL_UNSIGNED_BYTE, NULL);
        glBindTexture(GL_TEXTURE_2D, 0);

        // 将它附加到当前绑定的帧缓冲对象
        glFramebufferTexture2D(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_TEXTURE_2D, texture->TextureId, 0);

        if(glCheckFramebufferStatus(GL_FRAMEBUFFER) != GL_FRAMEBUFFER_COMPLETE)
            RedLog("\"ERROR::FRAMEBUFFER:: Framebuffer is not complete!\"");
        glBindFramebuffer(GL_FRAMEBUFFER, 0);
    }
}

GLTexture * DrawCall::getTexture()
{
    return texture;
}

DrawCall::~DrawCall()
{

}

void DrawCall::SetVAO(GLVAO * vao)
{
    this->vao = vao;
}

void DrawCall::Draw()
{
    glUseProgram(program->ProgramId);
    this->vao->DrawVAO();
}

////Uniform
void DrawCall::UniformInteger(char * uniform, int v)
{
    glUseProgram(program->ProgramId);
    glUniform1i(program->GetUniformLocation(uniform), v);
}

void DrawCall::UniformMatrix4fv(char * uniform, float * mat)
{
    glUseProgram(program->ProgramId);
    glUniformMatrix4fv(program->GetUniformLocation(uniform), 1, false, mat);
}

void DrawCall::UniformFloat(char * uniform, float v)
{
    glUseProgram(program->ProgramId);
    glUniform1f(program->GetUniformLocation(uniform), v);
}

void DrawCall::BindFrameBuffer()
{
    glBindFramebuffer(GL_FRAMEBUFFER,frameBuffer);
}

