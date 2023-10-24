export { default } from "next-auth/middleware";

export const config = { 
    matcher: ["/", 
        "/about", 
        "/deliveries",
        "/finance",
        "/items",
        "/planning",
        "/prediction",
        "/profile", 
        "/settings", 
        "/protected/:path*"
    ]};