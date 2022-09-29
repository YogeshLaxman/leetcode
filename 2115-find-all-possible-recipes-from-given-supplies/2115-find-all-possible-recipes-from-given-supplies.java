class Solution {
    Map<String, List<String>> recipeToIngredients;
    Set<String> suppliesSet;
    Map<String, Boolean> possibleRecipes;
    
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        recipeToIngredients = new HashMap<>();
        suppliesSet = new HashSet<>();
        possibleRecipes = new HashMap<>();
        
        for (int i=0; i<recipes.length; i++) {
            recipeToIngredients.put(recipes[i], ingredients.get(i));
        }
        
        for (String supply: supplies) {
            suppliesSet.add(supply);
        }
        
        for (String recipe: recipes) {
            isPossible(recipe, new HashSet<>());
        }
        
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry: possibleRecipes.entrySet()) {
            if (entry.getValue()) {
                ans.add(entry.getKey());
            }
        }
        
        return ans;
    }
    
    private boolean isPossible(String recipe, Set<String> seen) {
        
        
        if (possibleRecipes.containsKey(recipe)) 
            return possibleRecipes.get(recipe);
        
        if (suppliesSet.contains(recipe)) {
            possibleRecipes.put(recipe, true);
            return true;
        }
        
        
        
        List<String> ingredients = recipeToIngredients.get(recipe);
        seen.add(recipe);
        boolean possible = true;
        for (String ingredient: ingredients) {
            if (suppliesSet.contains(ingredient)) {
                continue;
            }
            
            if (recipeToIngredients.containsKey(ingredient) && !seen.contains(ingredient) && isPossible(ingredient, seen)) {
                continue;
            }
            
            possible = false;
            break;
        }
        
        possibleRecipes.put(recipe, possible);
        
        seen.remove(recipe);
        
        return possible;
    }
    
    
}