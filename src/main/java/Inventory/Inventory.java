package Inventory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Inventory {
    private HashMap<Integer,Product> aisleToProductMap;
    private HashMap<Integer,Integer> productIdToCountMap;

    PriorityQueue<Integer> availableAisles;

    public Inventory(int aisleCount)
    {
        availableAisles = new PriorityQueue<>();
        for(int aisleNo = 1;aisleNo<=aisleCount;aisleNo++)
        {
            availableAisles.add(aisleNo);
        }
        aisleToProductMap = new HashMap<>();
        productIdToCountMap = new HashMap<>();
    }

    public void addProduct(Product product) throws Exception
    {
        int productId = product.getId();
        int productCount = productIdToCountMap.getOrDefault(productId,0);
        if(productCount==0)
        {
            if(availableAisles.isEmpty())
            {
                throw new Exception("Out of space to add Product!");
            }
            aisleToProductMap.put(availableAisles.poll(),product);
        }
        productIdToCountMap.put(productId,productCount+1);
    }
    public Product getProductAt(int aisleNumber)
    {
        return aisleToProductMap.get(aisleNumber);
    }
    public boolean checkIfProductAvailable(int productId)
    {
        int productCount = productIdToCountMap.getOrDefault(productId,0);
        return productCount>0;
    }

    public void deductProductCount(int aisleNumber)
    {
        int productId = aisleToProductMap.get(aisleNumber).getId();
        int updatedProductCount = productIdToCountMap.get(productId)-1;
        if(updatedProductCount==0)
        {
            productIdToCountMap.remove(productId);
            aisleToProductMap.remove(aisleNumber);
            availableAisles.add(aisleNumber);
        }
        else {
            productIdToCountMap.put(productId,updatedProductCount);
        }
    }
}
