'use client';

import { useSession, SessionProvider } from 'next-auth/react';
import LoginButton from '@/components/LoginButton';
import TodoList from "@/components/TodoList";

export default function Home() {
    return (
        <SessionProvider>
            <Content/>
        </SessionProvider>
    );
}
function Content() {
  const { data: session } = useSession();

  return (
      <div>
        <h1>Welcome to the Todo App</h1>
        {session ? (
            <div>
              <p>Logged in as: {session?.user?.name || session?.user?.email}</p>
              plaa pla plaaa plaa logged in???
              <TodoList />

            </div>
        ) : (
            <div>
              <p>Please sign in to access the todo list.</p>
              <LoginButton />
            </div>
        )}
      </div>
  );
}
