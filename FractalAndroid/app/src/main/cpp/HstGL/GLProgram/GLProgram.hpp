#ifndef	REDGL_PROGRAM_H
#define	REDGL_PROGRAM_H

#include <vector>
#include "../GL.hpp"

class GLShader
{
private:
public:
    GLuint ShaderId;

    GLShader(GLenum type, const GLchar* src);
    ~GLShader();
    void DeleteShader();
};

class GLProgram
{
private:
public:
    GLuint ProgramId;
    std::vector<GLShader *> ShaderList;

    GLProgram();
    ~GLProgram();
    GLProgram(const char * vertexShaderSrc,const char * fragmentShaderSrc);

    void AddShader(GLShader * shader);
    void LinkProgram();
    void UseProgram();

    GLuint GetUniformLocation(char * name);

    void putMatrix4fv(char * name,const GLfloat* value);
    void put3f(char * name,GLfloat x,GLfloat y,GLfloat z);
    void put1i(char * name,GLint v);
    void put1f(char * name,GLfloat value);
};

#endif