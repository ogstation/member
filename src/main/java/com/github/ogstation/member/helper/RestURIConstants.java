package com.github.ogstation.member.helper;

public final class RestURIConstants
{

    // GlobalErrorHandlerController
    public static final String BAD_REQUEST_ERROR = "/api/error/400";
    public static final String UNAUTHORIZED_ERROR = "/api/error/401";
    public static final String FORBIDDEN_ERROR = "/api/error/403";
    public static final String NOT_FOUND_ERROR = "/api/error/404";
    public static final String METHOD_NOT_ALLOWED_ERROR = "/api/error/405";
    public static final String UNSUPPRTED_MEDIA_TYPE_ERROR = "/api/error/415";
    public static final String INTERNAL_ERROR = "/api/error/500";

    // MemberController
    public static final String CREATE_MEMBER = "/api/members";
    public static final String GET_ALL_MEMBER = "/api/members";
    public static final String GET_MEMBER = "/api/members/{id}";
    public static final String SEARCH_MEMBER = "/api/members/search";
    public static final String UPDATE_MEMBER = "/api/members/{id}";
    public static final String DELETE_MEMBER = "/api/members/{id}";

    private RestURIConstants()
    {
    }
}
