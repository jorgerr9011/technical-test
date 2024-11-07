package com.technical_test.technical_test;

import com.technical_test.technical_test.models.ProductModel;
import com.technical_test.technical_test.models.ProductSalesModel;
import com.technical_test.technical_test.models.ProductStockModel;
import com.technical_test.technical_test.services.ISortService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SortServiceTests {

    @Autowired
    private ISortService sortService;

    @Test
    public void testSortProducts_SuccessfulSorting() {
        // Datos de prueba para ventas y stock
        List<ProductSalesModel> salesList = Arrays.asList(
                new ProductSalesModel("1", 50000.0),
                new ProductSalesModel("2", 100000.0),
                new ProductSalesModel("3", 75000.0)
        );

        List<ProductStockModel> stockList = Arrays.asList(
                new ProductStockModel("1", 1000),
                new ProductStockModel("2", 4000),
                new ProductStockModel("3", 2000)
        );

        double salesWeight = 0.5;
        double stockWeight = 0.5;

        List<String> sortedProducts = sortService.sortProducts(salesWeight, stockWeight, salesList, stockList);

        // Los siguientes asserts son para validar el orden de los productos
        assertEquals("2", sortedProducts.get(0));
        assertEquals("3", sortedProducts.get(1));
        assertEquals("1", sortedProducts.get(2));
    }

    @Test
    public void testSortProducts_InvalidWeights() {

        List<ProductSalesModel> salesList = List.of(
                new ProductSalesModel("1", 50000.0)
        );
        List<ProductStockModel> stockList = List.of(
                new ProductStockModel("1", 1000)
        );

        double salesWeight = 0.7;
        double stockWeight = 0.4; // Los pesos no suman 1

        // Hay que verificar que se lanza una excepción con pesos inválidos
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sortService.sortProducts(salesWeight, stockWeight, salesList, stockList);
        });

        String expectedMessage = "Las ponderaciones deben sumar 1";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
