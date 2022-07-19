package com.example.student_project_repository;

public class RouteProtector {
    private static boolean protectedRoute = false;

    public static boolean isProtectedRoute() {
        return protectedRoute;
    }

    public void setProtectedRoute(boolean protectedRoute) {
        this.protectedRoute = protectedRoute;
    }
}
