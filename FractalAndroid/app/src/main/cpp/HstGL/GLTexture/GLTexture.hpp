#ifndef	REDGL_TEXTURE_H
#define	REDGL_TEXTURE_H

#include "../GL.hpp"

class GLTexture
{
private:
public:
    GLuint TextureId;

    GLTexture();
    void LoadImage(char * filePath);
    void SetData(unsigned char * data,int width,int height,GLenum internalFormat,GLenum format);
};


#endif