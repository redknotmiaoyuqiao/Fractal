#pragma once

#define	STRINGIZE(x)	#x

#ifdef __ANDROID__

#define	SHADER(shader) "#version 300 es\n precision highp float;\n" STRINGIZE(shader)
// #define	SHADER(shader) "" STRINGIZE(shader)

#else

#define	SHADER(shader) "#version 330\n" STRINGIZE(shader)

#endif