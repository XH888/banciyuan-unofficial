package com.xh.study.bcy.utils;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Constant {

    //---------------------获取数据刷新类型------------------------
    public static final int TYPE_LOAD = 1;
    public static final int TYPE_MORE = 2;
    public static final int TYPE_REFRESH = 3;


    @IntDef({
            TYPE_LOAD,
            TYPE_MORE,
            TYPE_REFRESH
    })
    public @Retention(RetentionPolicy.SOURCE) @interface LoadType {}

    //---------------------FeedBean数据类型------------------------
    public static final int TYPE_BEAN_NONE = 0;
    public static final int TYPE_BEAN_NOTE = 1;
    public static final int TYPE_BEAN_ARTICLE = 2;
    public static final int TYPE_BEAN_GANSWER = 3;

    @IntDef({
            TYPE_BEAN_NONE,
            TYPE_BEAN_NOTE, TYPE_BEAN_ARTICLE, TYPE_BEAN_GANSWER
    })
    public @Retention(RetentionPolicy.SOURCE) @interface FeedType {}


    //-------------------------加密参数-----------------------
    public static final String PARAMS_FRIENDFEED_LOAD = "JJiBgkck9BO7UuTB4HKVZIqHIl5M98aNymgE74FJL/YcB9MQ5hLMPJhJlPt/0xfpyz9CcX+B7nfME8rkX2Ina8k51r1C0rBzvfdGN1Wr02fS/8OZTC4fguwx1dbadIeZ";
    public static final String PARAMS_FRIENDFEED_LOAD_MORE = "JJiBgkck9BO7UuTB4HKVZIqHIl5M98aNymgE74FJL/be2SS7roLlCZmPvn4tvcANf7rpGC1QlL7WY6QUezNeocs/QnF/ge53zBPK5F9iJ2vJOda9QtKwc733RjdVq9Nn0v/DmUwuH4LsMdXW2nSHmQ==";
    public static final String PARAMS_FRIENDFEED_REFRESH = "JJiBgkck9BO7UuTB4HKVZIqHIl5M98aNymgE74FJL/ZTccYNgQBYtAWMOOkczQjU9JjoNEZMlP2dO4yR3SdAcMs/QnF/ge53zBPK5F9iJ2veGLfPOV/lofV1I/gOKhfQtb2Sqtie+wI1+ZMTJoNkOg==";

    public static final String PARAMS_TIMELINE_LOAD = "JJiBgkck9BO7UuTB4HKVZFP6HsWht6yj6YHGRj8ACrptOKHRDxYGhtmsC2Aj4qmzIOKIhdhJ2zFSMZs737IzxQ==";
    public static final String PARAMS_TIMELINE_LOAD_MORE = "JJiBgkck9BO7UuTB4HKVZFP6HsWht6yj6YHGRj8ACrptOKHRDxYGhtmsC2Aj4qmzIOKIhdhJ2zFSMZs737IzxQ==";
    public static final String PARAMS_TIMELINE_REFRESH = "JJiBgkck9BO7UuTB4HKVZFP6HsWht6yj6YHGRj8ACrrba0C5+iPM/OKQgV1CLvXAJeNU/gjVIFbnC1pClEF+6w==";

    public static final String PARAMS_TYPE_TAG_CIRCLE_GET = "fQq19VZM/kotWyAEV/9aMw==";
    public static final String PARAMS_WEEK_HOT_WORK_GET = "fQq19VZM/kotWyAEV/9aMw==";

    public static final String PARAMS_BANNER_GET = "JJiBgkck9BO7UuTB4HKVZPfS5q7hO3NeGYWNMP4JAgg=";
    public static final String PARAMS_RANK_TYPE_GET = "JJiBgkck9BO7UuTB4HKVZPfS5q7hO3NeGYWNMP4JAgg=";
    public static final String PARAMS_RELA_PROP_GET = "CK1T7PY/GkVY7ZiWjxAIFspXmIYKG3IfPDhdOqQoYmT30uau4TtzXhmFjTD+CQII";
    public static final String PARAMS_ITEM_HOTTAG_LOAD = "UMjdMOTXvayQwBiiq/niPkd1mppVp3+lmyJiZgoYPqCa6jJDJgm253hZdRJO77tJqIh74/scW2sqMokNhiZUrnlnZj36bIRnW+S3xU/d2wo=";
    public static final String PARAMS_ITEM_HOTTAG_LOAD_MORE = "UMjdMOTXvayQwBiiq/niPkd1mppVp3+lmyJiZgoYPqCa6jJDJgm253hZdRJO77tJZWlPf2j28brgrwJ5z5FsV7pKv1bUvI/F7c1IC2mBdGtUncSLzxJCAIxwM+lxzRZK";

    public static final String PARAMS_ATTEND_LOAD = "QMbWyb1x5jOqfKyrmrSTgdAIz39FEH3Gs1c2ZNB4z4KhQd7ZOxUBDuuqXMsvQTKX";
    public static final String PARAMS_ATTEND_LOAD_MORE="69rkQ9VvjsthQP7HovrxANAIz39FEH3Gs1c2ZNB4z4KhQd7ZOxUBDuuqXMsvQTKX";
    public static final String PARAMS_ATTEND_REFRESH = "QMbWyb1x5jOqfKyrmrSTgdAIz39FEH3Gs1c2ZNB4z4KhQd7ZOxUBDuuqXMsvQTKX";

    public static final String PARAMS_HOT_TAG_LOAD = "IUrJSKvkdS47TB7OgHebNZjO84Nyqn0yrk2T+JnkdRI=";

    //tag detail
    public static final String PARAMS_TAG_STATUS_GET = "fgwZPOR9vh3pJrwtkURis+gIPqECtU+/cVqvn6XfPDfCzAZC9bIPAq9R4h1M3W/t";
    public static final String PARAMS_TAG_ITEM_HOTTAG_LOAD = "GQZ32TO1889sv71UlfJ6XYepCN/ZBI75OzlPV6P41noLyfUkIesPZ7MBnJvyAbnXmuoyQyYJtud4WXUSTu+7Schz+f6itkAK1q5suicgPlQ=";
    public static final String PARAMS_TAG_ITEM_HOTTAG_LOAD_MORE = "GQZ32TO1889sv71UlfJ6XYepCN/ZBI75OzlPV6P41noLyfUkIesPZ7MBnJvyAbnXmuoyQyYJtud4WXUSTu+7SbfabX0cx9jKZP8Rt7C/4Ou+pDZSD4bQz7nCFOV6RORf";
    public static final String PARAMS_TAG_ITEM_HOTTAG_REFRESH = "GQZ32TO1889sv71UlfJ6XYepCN/ZBI75OzlPV6P41noLyfUkIesPZ7MBnJvyAbnXmuoyQyYJtud4WXUSTu+7SQa24DSEj+w3i5qizZib14A0KRcRCrJvFwlLfOCvXaRC";

    //user detail
    public static final String PARAMS_PERSON_DETAIL_GET ="JJiBgkck9BO7UuTB4HKVZGz0phG2rFH7oNir1mTu4iKQLU7eDZP8Ji5mCl9HEzIkCJKJyivtZ8U+EGwcWHs4qQ==" ;
    
    //user post detail
    public static String PARAMS_USER_POST_LOAD="w0H6zbbD72HRlGj66v20WNDvlCn1GDkbKqbPh2NcTWEGyk1pJWnUrg3Vvo0U2ttW59a8A+s4iDamEZseNHfvRtqcBf9O7N2r0M3ZbIrlj+Q=";
    public static String PARAMS_USER_POST_LOAD_MORE="w0H6zbbD72HRlGj66v20WNDvlCn1GDkbKqbPh2NcTWEGyk1pJWnUrg3Vvo0U2ttWC0ApEH0mS9N5UUQc/98q77axDaq4y/QQ6DWVNmnFZWmR8bJh4sp6hMMozUxNPEh/";
    public static String PARAMS_USER_POST_REFRESH=PARAMS_USER_POST_LOAD;

    //user ask
    public static String PARAMS_USER_ASK_LIST_LOAD="Saa5MPuOrGrl8z/IS3fLjiYu9g4HiT665krs+rrcmEXwkm4fTPRGbVo2PNsyne0adodUdnm0BxWN479hlEjHBw==";

}
