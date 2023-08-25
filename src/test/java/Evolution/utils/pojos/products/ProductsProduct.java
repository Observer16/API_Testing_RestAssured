package Evolution.utils.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsProduct {
    private String id;
    private String code;
    private String type;
    private String title;
    private String article;
    private double rating;
    private ArrayList<ProductsImage> images;
    private ProductsPrice price;
    private String categoryId;
    private Integer inBasket;
    private ArrayList<ProductsNameplate> nameplates;
}
