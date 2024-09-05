package com.pj224.app;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemExecute {
    public Result MemExecute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException;
}

