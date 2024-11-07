# Dependencias del proyecto

* Java 23

# Arrancar el proyecto

* Ejecutar la aplicación Spring boot:

        ./mvnw clean compile
        ./mvnw spring-boot:run


* Empaquetar el proyecto y ejecutarlo como aplicación .jar:

        ./mvnw clean package
        java -jar ./target/technical-test-0.0.1-SNAPSHOT.jar

# Casos de prueba

entrada1 = 
{
    
"salesWeight": 0.5,
    
"stockWeight": 0.5,
    
"productSales": [
        {"productId": "1", "sales": 50000},
        {"productId": "2", "sales": 100000},
        {"productId": "3", "sales": 100000},
        {"productId": "4", "sales": 75000}
    ],
    
"productStock": [
        {"productId": "1", "stock": 100000},
        {"productId": "2", "stock": 400000},
        {"productId": "3", "stock": 200000},
        {"productId": "4", "stock": 300000}
    ]

}

resultado1 = ["2", "4", "3", "1"]

entrada2 = {

"salesWeight": 0.8,

"stockWeight": 0.2,

"productSales": [
{"productId": "1", "sales": 50000},
{"productId": "2", "sales": 100000},
{"productId": "3", "sales": 100000},
{"productId": "4", "sales": 75000}
],

"productStock": [
{"productId": "1", "stock": 100000},
{"productId": "2", "stock": 400000},
{"productId": "3", "stock": 200000},
{"productId": "4", "stock": 300000}
]

}

resultado2 = [
"2",
"3",
"4",
"1"
]

entrada3 = {
    
"salesWeight": 0.2,
    
"stockWeight": 0.8,
    
"productSales": [
{"productId": "1", "sales": 50000},
{"productId": "2", "sales": 100000},
{"productId": "3", "sales": 100000},
{"productId": "4", "sales": 75000}
],

"productStock": [
{"productId": "1", "stock": 100000},
{"productId": "2", "stock": 400000},
{"productId": "3", "stock": 200000},
{"productId": "4", "stock": 300000}
]
}

resultado3 = [
"2",
"4",
"3",
"1"
]# technical-test
