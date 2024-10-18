import React from "react";
import { NavigationMenuLink, navigationMenuTriggerStyle } from "../ui/navigation-menu";
import { cn } from "@/lib/utils";
import Link from "next/link";
import { Url } from "next/dist/shared/lib/router/router";

export const ListItem = React.forwardRef<
  React.ElementRef<"div">,
  React.ComponentPropsWithoutRef<"div"> & {
    icon: React.ReactNode;
    children?: React.ReactNode;
    link: Url;
  }
>(({ className, title, icon, children, link, ...props }, ref) => {
  return (
    <li>
      <Link href={link} legacyBehavior passHref>
        <NavigationMenuLink asChild>
          <div
            ref={ref}
            className={cn(
              "block select-none space-y-1 rounded-md p-3 leading-none no-underline outline-none transition-colors hover:bg-accent hover:text-accent-foreground focus:bg-accent focus:text-accent-foreground",
              className
            )}
            {...props}
          >
            <div className="inline-flex items-center text-sm font-medium leading-none">
              {icon}
              {title}
            </div>
            {children && (
              <p className="line-clamp-2 text-sm leading-snug text-muted-foreground">
                {children}
              </p>
            )}
          </div>
        </NavigationMenuLink>
      </Link>
    </li>
  );
});
ListItem.displayName = "ListItem";
