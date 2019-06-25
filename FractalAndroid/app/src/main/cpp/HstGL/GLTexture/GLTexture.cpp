#include "GLTexture.hpp"

#include <stdio.h>
#include "IMAGE/file.hpp"

GLTexture::GLTexture()
{
    glGenTextures(1, &TextureId);
    glBindTexture(GL_TEXTURE_2D, TextureId);

    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

    //glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
    //glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);

    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

    glBindTexture(GL_TEXTURE_2D, 0);
}

void GLTexture::LoadImage(char * filePath)
{
    glBindTexture(GL_TEXTURE_2D, TextureId);
    
    /*
    int width, height;
    unsigned char* image = SOIL_load_image(filePath, &width, &height, 0, SOIL_LOAD_RGB);
    glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGB, GL_UNSIGNED_BYTE, image);
    printf("width:%d,height:%d\n",width,height);
    SOIL_free_image_data(image);
    */

    int width, height, channels;
    ImageFile * image = new ImageFile();
    unsigned char * data = image->ReadImage(filePath,&width,&height,&channels);

    RedLog("width:%d\n",width);
    RedLog("height:%d\n",height);
    RedLog("channels:%d\n",channels);

    glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGB, GL_UNSIGNED_BYTE, data);

    glBindTexture(GL_TEXTURE_2D, 0);
}

void GLTexture::SetData(unsigned char * data,int width,int height,GLenum internalFormat,GLenum format)
{
    glBindTexture(GL_TEXTURE_2D, TextureId);
    glTexImage2D(GL_TEXTURE_2D, 0, internalFormat, width, height, 0, format, GL_UNSIGNED_BYTE, data);
    glBindTexture(GL_TEXTURE_2D, 0);
}