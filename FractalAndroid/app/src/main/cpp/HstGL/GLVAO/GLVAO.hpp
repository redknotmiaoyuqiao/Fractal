#ifndef	REDGL_VAO_H
#define	REDGL_VAO_H

#include <vector>
#include "../GL.hpp"

class GLVAO
{
private:
public:
    GLuint VAOId;

    GLuint EBOId;

    std::vector<GLuint> VBOList;

    int DrawTime;

    GLVAO();
    ~GLVAO();
    void SetEBO(GLuint * EBOdata,int bufferSize);
    void AddVBO(GLfloat * VBOdata, int bufferSize, int layout, int size = 3, GLsizei stride = 0);
    void DrawVAO();
    void DeleteVAO();
};

#endif