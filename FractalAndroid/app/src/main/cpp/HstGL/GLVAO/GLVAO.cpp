#include "GLVAO.hpp"

GLVAO::GLVAO()
{
    glGenVertexArrays(1, &VAOId);
}

GLVAO::~GLVAO()
{
    this->DeleteVAO();
}

void GLVAO::SetEBO(GLuint * EBOdata,int bufferSize)
{
    DrawTime = bufferSize / (sizeof(int));

    glBindVertexArray(VAOId);

    glGenBuffers(1,&EBOId);
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBOId);
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, bufferSize, EBOdata, GL_STATIC_DRAW);

    glBindVertexArray(0);
}

void GLVAO::AddVBO(GLfloat * VBOdata,int bufferSize,int layout,int size, GLsizei stride)
{
    glBindVertexArray(VAOId);

    GLuint VBO;
    glGenBuffers(1,&VBO);

    glBindBuffer(GL_ARRAY_BUFFER, VBO);
    glBufferData(GL_ARRAY_BUFFER, bufferSize, VBOdata, GL_STATIC_DRAW);

    glVertexAttribPointer(layout, size, GL_FLOAT, GL_FALSE, stride, (GLvoid*)0);
    glEnableVertexAttribArray(layout);

    glBindVertexArray(0);
}

void GLVAO::DrawVAO()
{
    glBindVertexArray(VAOId);
    glDrawElements(GL_TRIANGLES, DrawTime, GL_UNSIGNED_INT, 0);
    glBindVertexArray(0);
}

void GLVAO::DeleteVAO()
{
    glDeleteVertexArrays(1, &VAOId);
}
