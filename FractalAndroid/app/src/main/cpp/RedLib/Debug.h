//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼                  BUG辟易
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？

#ifndef	RED_DEBUG_H
#define	RED_DEBUG_H

#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include <iostream>
#include <math.h>

#ifdef __ANDROID__

#include <android/log.h>
#define LOG_TAG "HST"
#define LOG_INFO(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOG_ERROR(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

#define RedLog(format, ...) LOG_ERROR(format, ##__VA_ARGS__)
#define BaseRedLog(format, ...) LOG_ERROR(format, ##__VA_ARGS__)

#else

#define RedLog(format, ...) RedPrintf((char *)__FILE__, (char *)__FUNCTION__ ,__LINE__,(char *)format, ##__VA_ARGS__)
#define BaseRedLog(format, ...) printf(format, ##__VA_ARGS__)

#endif


static void RedPrintf(char *file, char *function,int line,char * format,...)
{
    BaseRedLog("\033[;31m%s (%d) \033[0m\n",file,line);
    //BaseRedLog("%s (%d)",file,line);

    va_list ap;
    char *p;
    char *sval;
    int ival;
    double dval;
    va_start(ap,format);

    for(p=format;*p;p++)
    {
        if(*p!='%')
        {
            BaseRedLog("%c",*p);
            continue;
        }
        switch(*++p)
        {
        case 'd':
            ival=va_arg(ap,int);
            BaseRedLog("%d",ival);
            break;
        case 'f':
            dval=va_arg(ap,double);
            BaseRedLog("%f",dval);
            break;
        case 's':
            sval=va_arg(ap,char *);
            BaseRedLog("%s",sval);
            break;
        default:
            BaseRedLog("%c",*p);
            break;
        }
    }
    va_end(ap);
    BaseRedLog("\n");
}

#endif
