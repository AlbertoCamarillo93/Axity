from __future__ import annotations
from abc import ABC


class Mediator(ABC):
    """
    The Mediator interface declares a method used by components to notify the
    mediator about various events. The Mediator may react to these events and
    pass the execution to other components.
    """

    def notify(self, sender: object, event: str) -> None:
        pass


class ConcreteMediator(Mediator):
    def __init__(self, component1: Component1, component2: Component2) -> None:
        self._component1 = component1
        self._component1.mediator = self
        self._component2 = component2
        self._component2.mediator = self

    def notify(self, sender: object, event: str) -> None:
        if event == "hamburguesa":
            print("El Mediator reacciona a la hamburguesa y activa:")
            self._component2.do_c()
        elif event == "tacos":
            print("El Mediator reacciona a los tacos y activa:")
            self._component1.do_b()
            #self._component2.do_c()


class BaseComponent:
    """
    The Base Component provides the basic functionality of storing a mediator's
    instance inside component objects.
    """

    def __init__(self, mediator: Mediator = None) -> None:
        self._mediator = mediator

    @property
    def mediator(self) -> Mediator:
        return self._mediator

    @mediator.setter
    def mediator(self, mediator: Mediator) -> None:
        self._mediator = mediator


"""
Concrete Components implement various functionality. They don't depend on other
components. They also don't depend on any concrete mediator classes.
"""


class Component1(BaseComponent):
    def do_a(self) -> None:
        print("Prepara la hamburguesa.")
        self.mediator.notify(self, "hamburguesa")

    def do_b(self) -> None:
        print("Entregar taquitos.")
        self.mediator.notify(self, "B")


class Component2(BaseComponent):
    def do_c(self) -> None:
        print("Entregar hamburguesa.")
        self.mediator.notify(self, "C")

    def do_d(self) -> None:
        print("Se toma la carne del trompo.")
        self.mediator.notify(self, "tacos")


if __name__ == "__main__":
    # The client code.
    c1 = Component1()
    c2 = Component2()
    mediator = ConcreteMediator(c1, c2)

    print("\nEl cliente ordena una hamburguesa.")
    c1.do_a()

    print("\n", end="")

    print("El cliente ordena unos tacos.\n")
    c2.do_d()