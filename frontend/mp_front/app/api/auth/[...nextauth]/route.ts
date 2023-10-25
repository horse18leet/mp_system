import NextAuth from "next-auth";
import CredentialsProvider from "next-auth/providers/credentials";
import login  from "../signin";
import registration from "../signup";

export default NextAuth({
  providers: [
    CredentialsProvider({
        name: "signup",
        credentials: {
          firstName: {label: "Имя", type: "text"},
          email: {label: "E-mail", type: "email"},
          password: {label: "Пароль", type: "password"},
        },
        authorize: async (credentials) => {
          const result = await registration(credentials?.email, credentials?.password);
          if (result.success) {
            return Promise.resolve(result.user);
          } else {
            return Promise.resolve(null);
          }
        },
    }),
    CredentialsProvider({
      name: "signin",
      credentials: {
        email: {label: "E-mail", type: "email"},
        password: {label: "Пароль", type: "password"},
      },
      authorize: async (credentials) => {
        const result = await login(credentials?.email, credentials?.password);
        if (result.success) {
          return result.token;
        } else {
          return null;
        }
      },
  }),
  ],
  callbacks: {
    async signIn({ user }) {
      if (user) return true;

      return false;
    },
    async session({ session, token }: any) {
      session.user.accessToken = token.access_token;
      return session;
    },
    async jwt({ token, user }) {
      return token;
    },
  },
  // use env variable in production
  secret: "looselipssinkships",
});