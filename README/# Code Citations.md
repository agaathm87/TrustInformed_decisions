# Code Citations

This project uses or adapts code from the following sources:

---

## License: Apache-2.0  
https://github.com/jsaveta/SPIMBench/blob/2b653aa621a8ee6c8c9ae1c87d227c17be781af3/src/eu/ldbc/semanticpublishing/util/CosineUtil.java

```java
return 0.0;
    }
    double dotProduct = 0.0;
    double normA = 0.0;
    double normB = 0.0;
    for (int i = 0; i < vecA.length; i++) {
        dotProduct += vecA[i] * vecB[i];
        normA += Math.pow(vecA[i], 2);
        normB += Math.pow(vecB[i], 2);
    }
    return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
```

---

## License: unknown  
https://github.com/hellokathy/cs7637-kbai/blob/1001dd6b60255e24e9a9a500c58634b31bd04f11/project3/src/project3/VectorExt.java

```java
return 0.0;
    }
    double dotProduct = 0.0;
    double normA = 0.0;
    double normB = 0.0;
    for (int i = 0; i < a.length; i++) {
        dotProduct += a[i] * b[i];
        normA += Math.pow(a[i], 2);
        normB += Math.pow(b[i], 2);
    }
    return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
```

---

## License: unknown  
https://github.com/jinfenglin/AIDE/blob/2743fc5cc750883abe8e11b7032f7bda313fe30f/src/recommandation/Hybird.java

```java
return 0.0;
    }
    double dotProduct = 0.0;
    double normA = 0.0;
    double normB = 0.0;
    for (int i = 0; i < v1.length; i++) {
        dotProduct += v1[i] * v2[i];
        normA += Math.pow(v1[i], 2);
        normB += Math.pow(v2[i], 2);
    }
    return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
```

---

## License: unknown  
https://github.com/nameof/tfidf-similarity/blob/eebc193ca9619f35251e80824080fe7cdb8137d9/src/main/java/com/nameof/tfidf/similarity/TfidfSimilarityCalculator.java

```java
return 0.0;
    }
    double dotProduct = 0.0;
    double normA = 0.0;
    double normB = 0.0;
    for (int i = 0; i < vectorA.length; i++) {
        dotProduct += vectorA[i] * vectorB[i];
        normA += Math.pow(vectorA[i], 2);
        normB += Math.pow(vectorB[i], 2);
    }
    return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
```
## License: MIT  
https://github.com/basten-leeftink/PaperTrustworthiness

```java
public class RootCalculator {

    public static double calculateRoot(String number, String root) {
        double numberInt = Double.parseDouble(number);
        double rootInt = Double.parseDouble(root);
        if (rootInt <= 0) {
            throw new IllegalArgumentException("Root must be greater than 0");
        }
        return Math.pow(numberInt, 1.0 / rootInt);
    }
}
```

## License: MIT  
https://github.com/FrederiqueLalieu/Trust-dynamics


## License: MIT  
https://github.com/ZurekTom/Benevolence-paper

