This is a [Next.js](https://nextjs.org) project bootstrapped with [`create-next-app`](https://github.com/vercel/next.js/tree/canary/packages/create-next-app).

## Requirements
keycloak needs to be up and running

## Getting Started

create .env.local under todo-app folder and add
NEXTAUTH_SECRET=<your secret>
KEYCLOAK_FRONTEND_CLIENT_ID=>keycloak client id>
KEYCLOAK_ISSUER_URL=<keycloak realm address>
KEYCLOAK_CLIENT_SECRET=<confidential client secret>

First, run the development server:

```bash
npm run dev
```

Open [http://localhost:3000](http://localhost:3000) see the result

[Next.js Documentation](https://nextjs.org/docs) - Next.js documentation that might help
Maybe usefull info:https://authjs.dev/getting-started/authentication/oauth
