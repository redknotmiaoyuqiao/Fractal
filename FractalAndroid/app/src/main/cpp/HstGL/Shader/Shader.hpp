#pragma once

#include "Header.hpp"

static const char * Line_Vertex_Shader = SHADER(
        \#version 300 es\n
        precision highp float;
        layout (location = 0) in vec3 position;
        layout (location = 1) in vec3 texCoord;

        out vec4 TexCoord;

        uniform mat4 lineMatrix;

        void main()
        {
                gl_Position = lineMatrix * vec4(position, 1.0);
                TexCoord = vec4(texCoord,1.0);
        }

);

static const char * Line_Fragment_Shader = SHADER(
        \#version 300 es\n
        precision highp float;
        in vec4 TexCoord;

        out vec4 color;

        uniform int isRed;

        void main()
        {
            if(isRed == 0){
                color = vec4(0.0,1.0,0.0,1.0);
            }else{
                color = vec4(1.0,0.0,0.0,1.0);
            }

        }

);

static const char * Camera_Vertex_Shader = SHADER(
        \#version 300 es\n
        precision highp float;
        layout (location = 0) in vec3 position;
        layout (location = 1) in vec3 texCoord;

        uniform mat4 transformMatrix;

        out vec4 CameraTexCoord;
        out vec4 TexCoord;

        void main()
        {
            gl_Position = vec4(position, 1.0f);

            vec4 temp = vec4(texCoord,1.0);
            temp.z = 0.0;

            CameraTexCoord = transformMatrix * temp;
            TexCoord = temp;
        }

);


static const char * Camera_Fragment_Shader = SHADER(
        \#version 300 es\n
        \#extension \G\L_OES_EGL_image_external_essl3 : require\n
        precision highp float;

        in vec4 TexCoord;
        in vec4 CameraTexCoord;

        out vec4 color;

        uniform samplerExternalOES camera_texture;

        void main()
        {
            vec2 t = vec2(1.0 - CameraTexCoord.x,CameraTexCoord.y);
            color = texture(camera_texture, t);

            //float g = color.r * 0.299 + color.g * 0.587 + color.b * 0.114;
            //color = vec4(g,g,g,1.0);
        }
);



static const char * Snapshot_Vertex_Shader = SHADER(
        \#version 300 es\n
        precision highp float;
        layout (location = 0) in vec3 position;
        layout (location = 1) in vec3 texCoord;

        uniform mat4 transformMatrix;

        out vec4 CameraTexCoord;
        out vec4 TexCoord;

        void main()
        {
                gl_Position = vec4(position, 1.0f);

                vec4 temp = vec4(texCoord,1.0);
                temp.z = 0.0;

                CameraTexCoord = transformMatrix * temp;
                TexCoord = temp;
        }

);


static const char * Snapshot_Fragment_Shader = SHADER(
        \#version 300 es\n
        \#extension \G\L_OES_EGL_image_external_essl3 : require\n
        precision highp float;

        in vec4 TexCoord;
        in vec4 CameraTexCoord;

        out vec4 color;

        uniform samplerExternalOES camera_texture;

        void main()
        {
                vec2 t = vec2(1.0 - CameraTexCoord.x,CameraTexCoord.y);
                color = texture(camera_texture, t);

        }
);



static const char * Camera_Show_Fragment_Shader = SHADER(
        \#version 300 es\n
        \#extension \G\L_OES_EGL_image_external_essl3 : require\n
        precision highp float;

        in vec4 TexCoord;
        in vec4 CameraTexCoord;

        out vec4 color;

        uniform samplerExternalOES camera_texture;
        uniform sampler2D icon_texture;

        void main()
        {
                vec2 camT = vec2(CameraTexCoord.x,CameraTexCoord.y);
                vec4 cam_color = texture(camera_texture, camT);

                vec2 t = vec2(TexCoord.x,1.0 - TexCoord.y);
                t.x = t.x * 3.0;
                t.y = t.y * 9.0;
                vec4 icon_color = texture(icon_texture, t);
                t.x = t.x - 2.0;
                t.y = t.y;
                if(t.x > 1.0 || t.y > 1.0 || t.x < 0.0 || t.y < 0.0){
                    icon_color.r = 1.0;
                }

                if(icon_color.r < 0.5){
                    color = mix(cam_color, vec4(1.0), 0.7);
                    //color = icon_color;
                }
                else{
                    color = cam_color;
                }


                //float g = (color.r + color.g + color.b) / 3.0;
                //color = vec4(g,g,g,1.0);
        }
);

static const char * Test_Vertex_Shader = SHADER(
                layout (location = 0) in vec3 position;
                layout (location = 1) in vec3 texCoord;

                out vec3 ourColor;
                out vec3 TexCoord;

                void main()
                {
                    gl_Position = vec4(position, 1.0f);
                    TexCoord = texCoord;
                }
            );

static const char * Test_Fragment_Shader = SHADER(
                in vec3 TexCoord;

                out vec4 color;

                uniform sampler2D ttt;
                uniform samplerExternalOES camera_texture;

                void main()
                {
                    vec2 t = vec2(TexCoord.x,1.0 - TexCoord.y);
                    vec4 water = texture(ttt, t);
                    //color = vec4(TexCoord,1.0);
                    color = vec4(TexCoord,1.0);

                    color = texture(camera_texture, t);
                }
            );         

static const char * YUV420_Vertex_Shader = SHADER(
                layout (location = 0) in vec3 position;
                layout (location = 1) in vec3 texCoord;

                out vec3 ourColor;
                out vec3 TexCoord;

                void main()
                {
                    gl_Position = vec4(position, 1.0f);
                    TexCoord = texCoord;
                }
            );

static const char * YUV420_Fragment_Shader = SHADER(
                in vec3 TexCoord;

                out vec4 color;

                uniform sampler2D y;
                uniform sampler2D u;
                uniform sampler2D v;

                uniform float point;

                void main()
                {
                    float t_x = TexCoord.x;
                    float t_y = TexCoord.y;

                    vec2 t = vec2(t_x,1.0 - t_y);

                    float y = texture(y, t).r;
                    color = vec4(y,y,y,1.0);
                    
                    /*
                    vec3 yuv;
                    vec3 rgb;

                    yuv.x = texture(y, t).r;
                    yuv.y = texture(u, t).r - 0.5;
                    yuv.z = texture(v, t).r - 0.5;

                    rgb = mat3( 1,       1,         1,
                                0,       -0.39465,  2.03211,
                                1.13983, -0.58060,  0) * yuv;

                                */

                    //color = texture(y, t);

                    //color = vec4(yuv.x,yuv.x,yuv.x,1.0);


                    //color = vec4(rgb,1.0);
                }
            );

static const char * Julia_Vertex_Shader = SHADER(
                layout (location = 0) in vec3 position;
                layout (location = 1) in vec3 texCoord;

                out vec3 TexCoord;

                void main()
                {
                    gl_Position = vec4(position, 1.0f);
                    TexCoord = texCoord;
                }
            );

static const char * Julia_Fragment_Shader = SHADER(
                in vec3 TexCoord;

                out vec4 color;

                uniform float iTime;
                uniform float width;
                uniform float height;

                void main()
                {
                    //vec2 iResolution = vec2(width,height);
                    vec2 fragCoord = vec2(width * TexCoord.x,height * TexCoord.y);
                    vec2 iResolution = vec2(width,height);
                    vec2 z = 1.15*(-iResolution.xy + 2.0 * fragCoord.xy) / iResolution.y;

                    vec2 an = 0.51*cos( vec2(0.0,1.5708) + 0.1*iTime ) - 0.25*cos( vec2(0.0,1.5708) + 0.2*iTime );

                    float f = 1e20;

                    for( int i=0; i<128; i++ )
                    {
                        z = vec2( z.x*z.x-z.y*z.y, 2.0*z.x*z.y ) + an;
                        f = min( f, dot(z,z) );
                    }

                    f = 1.0+log(f)/16.0;

                    color = vec4(f,f*f,f*f*f,1.0);
                }
            );