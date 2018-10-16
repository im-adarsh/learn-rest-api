package com.clydoskope.code.endpoints;

import org.springframework.web.bind.annotation.RequestMethod;

public enum EndPoints {

    GET_USER("/api/v1/user", "/{userId}", RequestMethod.GET),
    UPDATE_USER("/api/v1/user", "/{userId}", RequestMethod.POST);


    private final String prefix;
    private final String methodUrl;
    private final RequestMethod method;
    private final String url;

    private EndPoints(final String prefix, final String methodUrl, final RequestMethod method) {
        this.prefix = prefix;
        this.methodUrl = methodUrl;
        this.method = method;
        this.url = prefix + methodUrl;
    }

    public String getMethodUrl() {
        return this.methodUrl;
    }

    public RequestMethod getRequestMethod() {
        return this.method;
    }


}
