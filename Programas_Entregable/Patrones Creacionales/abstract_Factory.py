from __future__ import annotations
from abc import ABC, abstractmethod

class AbstractFactory(ABC):
    """
    La interfaz AbstractFactory declara un conjunto de métodos que devuelven
    diferentes productos abstractos. Estos productos se denominan familia y son
    relacionados por un tema o concepto de alto nivel. Los productos de una familia suelen ser
    capaces de colaborar entre ellos. Una familia de productos puede tener varios
    variantes, pero los productos de una variante son incompatibles con los productos de
    otro.
    """
    @abstractmethod
    def create_product_a(self) -> AbstractProductA:
        pass

    @abstractmethod
    def create_product_b(self) -> AbstractProductB:
        pass

class ConcreteFactory1(AbstractFactory):
    """
    Las Concrete Factories producen una familia de productos que pertenecen a un solo
    variante. La fábrica garantiza que los productos resultantes sean compatibles. Nota
    que las firmas de los métodos de Concrete Factory devuelven un resumen
    producto, mientras que dentro del método se instancia un producto concreto.
    """

    def create_product_a(self) -> AbstractProductA:
        return ConcreteProductA1()

    def create_product_b(self) -> AbstractProductB:
        return ConcreteProductB1()

class ConcreteFactory2(AbstractFactory):
    """
    Cada Concrete Factory tiene una variante de producto correspondiente.
    """

    def create_product_a(self) -> AbstractProductA:
        return ConcreteProductA2()

    def create_product_b(self) -> AbstractProductB:
        return ConcreteProductB2()


class AbstractProductA(ABC):
    """
    Cada producto distinto de una familia de productos debe tener una interfaz básica. 
    Todas las variantes del producto deben implementar esta interfaz.
    """

    @abstractmethod
    def useful_function_a(self) -> str:
        pass


"""
Los Concrete Products son creados por las correspondientes Concrete Factories.
"""
class ConcreteProductA1(AbstractProductA):
    def useful_function_a(self) -> str:
        return 'Rines de  aluminio.'


class ConcreteProductA2(AbstractProductA):
    def useful_function_a(self) -> str:
        return 'Rines de acero.'


class AbstractProductB(ABC):
    """
    Aquí está la interfaz base de otro producto. Todos los productos pueden interactuar
    entre sí, pero la interacción adecuada sólo es posible entre productos de
    la misma concrete variant.
    """
    @abstractmethod
    def useful_function_b(self) -> None:
        """
        El producto B es capaz de hacer sus propias cosas ......
        """
        pass

    @abstractmethod
    def another_useful_function_b(self, collaborator: AbstractProductA) -> None:
        """
        ...pero también puede colaborar con ProductA.

        El AbstractFactory se asegura de que todos los productos que crea sean del
        misma variante y, por tanto, compatible.
        """
        pass


"""
Los Concrete Products son creados por las correspondientes Concrete Factories.
"""
class ConcreteProductB1(AbstractProductB):
    def useful_function_b(self) -> str:
        return 'El carro es un auto de lujo.'

    """
    La variante, Producto B1, solo puede funcionar correctamente con la variante,
    Producto A1. Sin embargo, acepta cualquier instancia de AbstractProductA como un
    argumento.
    """

    def another_useful_function_b(self, collaborator: AbstractProductA) -> str:
        result = collaborator.useful_function_a()
        return f"Este es un carro de lujo con ({result})"


class ConcreteProductB2(AbstractProductB):
    def useful_function_b(self) -> str:
        return 'El carro es un auto de austero.' 

    def another_useful_function_b(self, collaborator: AbstractProductA):
        """
        La variante, Producto B2, solo puede funcionar correctamente con el
        variante, Producto A2. No obstante, acepta cualquier instancia de
        AbstractProductA como argumento.
        """
        result = collaborator.useful_function_a()
        return  f"Este es un carro de austero con ({result})"

def client_code(factory: AbstractFactory) -> None:
    """
    El client_code funciona con factories y products solo a través de 
    tipos abstractos: AbstractFactory y AbstractProduct. Esto te permite pasar por cualquier factory
    o subclase de producto al client_code sin romperlo.

    The client code works with factories and products only through abstract
    types: AbstractFactory and AbstractProduct. This lets you pass any factory
    or product subclass to the client code without breaking it.
    """
    product_a = factory.create_product_a()
    product_b = factory.create_product_b()

    print(f"{product_b.useful_function_b()}")
    print(f"{product_b.another_useful_function_b(product_a)}", end="")


if __name__ == "__main__":
    """
    El client_code puede funcionar con cualquier concrete factory class.
    """
    print("Client: Testing client code with the first factory type:")
    client_code(ConcreteFactory1())

    print("\n")

    print("Client: Testing the same client code with the second factory type:")
    client_code(ConcreteFactory2())