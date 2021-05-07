from __future__ import annotations
from abc import ABC, abstractmethod


class Command(ABC):
    """
    The Command interface declares a method for executing a command.
    """

    @abstractmethod
    def execute(self) -> None:
        pass


class SimpleCommand(Command):
    """
    Some commands can implement simple operations on their own.
    """

    def __init__(self, payload: str) -> None:
        self._payload = payload

    def execute(self) -> None:
        print(f"SimpleCommand: después se ejecuta SimpleCommand y aparte puede hacer algo más, como esto:"
              f"({self._payload})\n")


class ComplexCommand(Command):
    """
    However, some commands can delegate more complex operations to other
    objects, called "receivers."
    """

    def __init__(self, receiver: Receiver, a: str, b: str) -> None:
        """
        Complex commands can accept one or several receiver objects along with
        any context data via the constructor.
        """

        self._receiver = receiver
        self._a = a
        self._b = b

    def execute(self) -> None:
        """
        Commands can delegate to any methods of a receiver.
        """

        print("ComplexCommand: Complex es casi el último en imprimirse, pero aún faltan unos amigos...\n", end="")
        self._receiver.do_something(self._a)
        self._receiver.do_something_else(self._b)


class Receiver:
    """
    The Receiver classes contain some important business logic. They know how to
    perform all kinds of operations, associated with carrying out a request. In
    fact, any class may serve as a Receiver.
    """

    def do_something(self, a: str) -> None:
        print(f"\nReceiver: Aquí recibimos un parametro que viene desde el main --> ({a}.)\n", end="")

    def do_something_else(self, b: str) -> None:
        print(f"\nReceiver: Y aquí acabo todo, junto con otro parámetro del main --> ({b}.)", end="")


class Invoker:
    """
    The Invoker is associated with one or several commands. It sends a request
    to the command.
    """

    _on_start = None
    _on_finish = None

    """
    Initialize commands.
    """

    def set_on_start(self, command: Command):
        self._on_start = command

    def set_on_finish(self, command: Command):
        self._on_finish = command

    def do_something_important(self) -> None:
        """
        The Invoker does not depend on concrete command or receiver classes. The
        Invoker passes a request to a receiver indirectly, by executing a
        command.
        """

        print("Invoker: Es el primero en ejecutarse\n")
        if isinstance(self._on_start, Command):
            self._on_start.execute()

        print("Invoker: Ahora volvimos a invoker... porque es cool\n")

        print("Invoker: Y si creias que te habías libro de invoker te equivocaste.\n")
        if isinstance(self._on_finish, Command):
            self._on_finish.execute()


if __name__ == "__main__":
    """
    The client code can parameterize an invoker with any commands.
    """

    invoker = Invoker()
    invoker.set_on_start(SimpleCommand("Hola a todos!"))
    receiver = Receiver()
    invoker.set_on_finish(ComplexCommand(
        receiver, "Yo soy el 1 de los parámetros", "Yo soy el 2 de los parámetros"))

    invoker.do_something_important()