#pragma once
#pragma warning(disable:4996)

#include <string>
#include "RedLib/Debug.h"
#include <string.h>

class ImageFile
{
public:
    ImageFile();
    ~ImageFile();

    unsigned char * ReadImage(const char * path,int * width,int * height,int * nrChannels);
	float * ReadHdrImage(const char * path, int * width, int * height, int * nrChannels);
};

class File{
public:
    static std::string getResPath(std::string path){
        //return "/Users/redknot/RedEyeEngine/res/" + path;
		return "C://RedEyeEngine/res/" + path;
        //return "/storage/emulated/0/res/" + path;
    }

    static char * getResPathCStr(std::string path){
        //std::string p = "/Users/redknot/RedEyeEngine/res/" + path;
		std::string p = "C://RedEyeEngine/res/" + path;
        //std::string p = "/storage/emulated/0/res/" + path;

        RedLog("\nPath:%s\n",p.c_str());

        char * str = (char *)malloc(p.size());

        strcpy(str,p.c_str());

        return str;
    }
};