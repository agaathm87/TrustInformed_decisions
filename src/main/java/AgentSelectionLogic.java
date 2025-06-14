package nl.uva.agentselection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class AgentSelectionLogic {

    // --- Helper class for pairing scores with agent names ---
    // Used for sorting and filtering agents based on a score (e.g., benevolence, incompetence)
    public static class ScoreAgentPair {
        double score;
        String agent;

        public ScoreAgentPair(double score, String agent) {
            this.score = score;
            this.agent = agent;
        }

        public double getScore() {
            return score;
        }

        public String getAgent() {
            return agent;
        }
    }

    // --- RealBeliefSource: stores all beliefs as vectors and values ---
    // This class is the main belief base, storing all agent, goal, and trustor data
    public static class RealBeliefSource {
        private final List<String> agents = new ArrayList<>();
        private final Map<String, List<Double>> agentVectors = new HashMap<>();
        private final Map<String, List<Double>> goalVectors = new HashMap<>();
        private final Map<String, List<Double>> trustorVectors = new HashMap<>();
        private final Map<String, Double> trustworthinessScores = new HashMap<>();
        private final Map<String, Double> untrustworthinessScores = new HashMap<>();
        private final Map<String, Double> benevolenceScores = new HashMap<>();
        private final Map<String, Double> competenceScores = new HashMap<>();
        private final Map<String, Double> integrityScores = new HashMap<>();
        private final Map<String, Double> incompetenceScores = new HashMap<>();
        private final Map<String, String> relationshipTypes = new HashMap<>();
        private final Map<String, Double> relationshipStrengths = new HashMap<>();

        // --- Setters for ASL communication ---
        // These methods are called from static methods (which are called from ASL)
        public void setAgentVector(String agent, String goal, List<Double> vector) {
            if (!agents.contains(agent)) agents.add(agent);
            agentVectors.put(agent + "_" + goal, vector);
        }
        public void setGoalVector(String goal, List<Double> vector) {
            goalVectors.put(goal, vector);
        }
        public void setTrustorVector(String trustor, String goal, List<Double> vector) {
            trustorVectors.put(trustor + "_" + goal, vector);
        }
        public void setTrustworthinessScore(String agent, String goal, double score) {
            trustworthinessScores.put(agent + "_" + goal, score);
        }
        public void setUntrustworthinessScore(String agent, String goal, double score) {
            untrustworthinessScores.put(agent + "_" + goal, score);
        }
        public void setBenevolenceScore(String agent, String goal, double score) {
            benevolenceScores.put(agent + "_" + goal, score);
        }
        public void setCompetenceScore(String agent, String goal, double score) {
            competenceScores.put(agent + "_" + goal, score);
        }
        public void setIntegrityScore(String agent, String goal, double score) {
            integrityScores.put(agent + "_" + goal, score);
        }
        public void setIncompetenceScore(String agent, String goal, double score) {
            incompetenceScores.put(agent + "_" + goal, score);
        }
        public void setRelationshipType(String trustor, String agent, String type) {
            relationshipTypes.put(trustor + "_" + agent, type);
        }
        public void setRelationshipStrength(String trustor, String agent, double strength) {
            relationshipStrengths.put(trustor + "_" + agent, strength);
        }

        // --- Getters for selection logic ---
        public List<String> getAllAgentNames() { return new ArrayList<>(agents); }
        public Double getTrustworthinessScore(String agent, String goal) { return trustworthinessScores.get(agent + "_" + goal); }
        public Double getUntrustworthinessScore(String agent, String goal) { return untrustworthinessScores.get(agent + "_" + goal); }
        public Double getBenevolenceScore(String agent, String goal) { return benevolenceScores.get(agent + "_" + goal); }
        public Double getCompetenceScore(String agent, String goal) { return competenceScores.get(agent + "_" + goal); }
        public Double getIntegrityScore(String agent, String goal) { return integrityScores.get(agent + "_" + goal); }
        public Double getIncompetenceScore(String agent, String goal) { return incompetenceScores.get(agent + "_" + goal); }
        public String getRelationshipType(String trustor, String agent) { return relationshipTypes.get(trustor + "_" + agent); }
        public Double getRelationshipStrength(String trustor, String agent) { return relationshipStrengths.get(trustor + "_" + agent); }
        public List<Double> getAgentVector(String agent, String goal) { return agentVectors.get(agent + "_" + goal); }
        public List<Double> getGoalVector(String goal) { return goalVectors.get(goal); }
        public List<Double> getTrustorVector(String trustor, String goal) { return trustorVectors.get(trustor + "_" + goal); }
    }
// Returns cosine similarity between agent and goal vectors
public static double getAgentGoalCosineSimilarity(String agent, String goal) {
    List<Double> agentVec = beliefBaseInstance.getAgentVector(agent, goal);
    List<Double> goalVec = beliefBaseInstance.getGoalVector(goal);
    return CosineSimilarity.calculate(agentVec, goalVec);
}
public static double getTrustorAgentCosineSimilarity(String trustor, String agent, String goal) {
    List<Double> trustorVec = beliefBaseInstance.getTrustorVector(trustor, goal);
    List<Double> agentVec = beliefBaseInstance.getAgentVector(agent, goal);
    return CosineSimilarity.calculate(trustorVec, agentVec);
}
    // --- Static reference for ASL-Java communication ---
    // This is the single instance used for all belief storage and retrieval
    public static RealBeliefSource beliefBaseInstance = new RealBeliefSource();

    // --- Static methods for ASL communication ---
    // These are called from ASL using internal actions to update the Java belief base
public static void addAgentVector(String agent, String goal, Object b, Object c, Object i) {
    double bd = Double.parseDouble(b.toString());
    double cd = Double.parseDouble(c.toString());
    double id = Double.parseDouble(i.toString());
    beliefBaseInstance.setAgentVector(agent, goal, List.of(bd, cd, id));
}

public static void addGoalVector(String goal, Object b, Object c, Object i) {
    double bd = Double.parseDouble(b.toString());
    double cd = Double.parseDouble(c.toString());
    double id = Double.parseDouble(i.toString());
    beliefBaseInstance.setGoalVector(goal, List.of(bd, cd, id));
}

public static void addTrustorVector(String trustor, String goal, Object b, Object c, Object i) {
    double bd = Double.parseDouble(b.toString());
    double cd = Double.parseDouble(c.toString());
    double id = Double.parseDouble(i.toString());
    beliefBaseInstance.setTrustorVector(trustor, goal, List.of(bd, cd, id));
}

public static void addTrustworthiness(String agent, String goal, Object score) {
    double s = Double.parseDouble(score.toString());
    beliefBaseInstance.setTrustworthinessScore(agent, goal, s);
}

public static void addUntrustworthiness(String agent, String goal, Object score) {
    double s = Double.parseDouble(score.toString());
    beliefBaseInstance.setUntrustworthinessScore(agent, goal, s);
}

public static void addBenevolence(String agent, String goal, Object score) {
    double s = Double.parseDouble(score.toString());
    beliefBaseInstance.setBenevolenceScore(agent, goal, s);
    
}
public static void addCompetence(String agent, String goal, Object score) {
    double s = Double.parseDouble(score.toString());
    beliefBaseInstance.setCompetenceScore(agent, goal, s);
}

public static void addIntegrity(String agent, String goal, Object score) {
    double s = Double.parseDouble(score.toString());
    beliefBaseInstance.setIntegrityScore(agent, goal, s);
}

public static void addIncompetence(String agent, String goal, Object score) {
    double s = Double.parseDouble(score.toString());
    beliefBaseInstance.setIncompetenceScore(agent, goal, s);
}

public static void addRelationship(String trustor, String agent, String type, Object strength) {
    double s = Double.parseDouble(strength.toString());
    beliefBaseInstance.setRelationshipType(trustor, agent, type);
    beliefBaseInstance.setRelationshipStrength(trustor, agent, s);
}
    

    // --- Cosine similarity utility for vector comparison ---
    // Used to compare agent, goal, and trustor vectors for similarity
    public static class CosineSimilarity {
        public static double calculate(List<Double> vectorA, List<Double> vectorB) {
            if (vectorA == null || vectorB == null || vectorA.isEmpty() || vectorB.isEmpty() || vectorA.size() != vectorB.size()) {
                return 0.0;
            }
            double dotProduct = 0.0;
            double normA = 0.0;
            double normB = 0.0;
            for (int i = 0; i < vectorA.size(); i++) {
                dotProduct += vectorA.get(i) * vectorB.get(i);
                normA += Math.pow(vectorA.get(i), 2);
                normB += Math.pow(vectorB.get(i), 2);
            }
            if (normA == 0.0 || normB == 0.0) {
                return 0.0;
            }
            return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
        }
    }

    // --- Main agent selection logic ---
    // This method selects the best agent for a given goal and trustor using hierarchical criteria
    public static String startHierarchicalSelection(String goal, String trustor) {
        List<String> allAvailableAgents = beliefBaseInstance.getAllAgentNames();
        if (allAvailableAgents == null || allAvailableAgents.isEmpty()) {
            return "none_available";
        }

        List<String> trustworthyAgents = new ArrayList<>();
        List<String> untrustworthyAgents = new ArrayList<>();

        // Separate agents into trustworthy and untrustworthy based on available scores
        for (String agent : allAvailableAgents) {
            Double tScore = beliefBaseInstance.getTrustworthinessScore(agent, goal);
            Double uScore = beliefBaseInstance.getUntrustworthinessScore(agent, goal);
            if (tScore != null && uScore == null) {
                trustworthyAgents.add(agent);
            } else if (uScore != null) {
                untrustworthyAgents.add(agent);
            }
        }

        String selectedAgent = "none_found";

        // Try to select from trustworthy agents first, then untrustworthy
        if (!trustworthyAgents.isEmpty()) {
            List<String> decisiveAgents = decisiveRelationshipSimilarity(goal, trustor, trustworthyAgents);
            selectedAgent = selectFromDecisiveAgents(decisiveAgents, goal, trustor, false);
            if (!"none_found".equals(selectedAgent)) return selectedAgent;
        }
        if (!untrustworthyAgents.isEmpty()) {
            List<String> decisiveAgents = decisiveRelationshipSimilarity(goal, trustor, untrustworthyAgents);
            selectedAgent = selectFromDecisiveAgents(decisiveAgents, goal, trustor, true);
            if (!"none_found".equals(selectedAgent)) return selectedAgent;
        }
        // If no scores at all, return special code
        if (allAvailableAgents.stream().noneMatch(a ->
                beliefBaseInstance.getTrustworthinessScore(a, goal) != null ||
                beliefBaseInstance.getUntrustworthinessScore(a, goal) != null)) {
            selectedAgent = "none_found_no_scores";
        } else {
            selectedAgent = "none_available";
        }
        return selectedAgent;
    }

    // --- Hierarchical selection among a set of candidate agents ---
    private static String selectFromDecisiveAgents(List<String> decisiveAgents, String goal, String trustor, boolean isUntrustworthy) {
        if (decisiveAgents == null || decisiveAgents.isEmpty()) {
            return "none_found";
        }
        if (decisiveAgents.size() == 1) {
            return decisiveAgents.get(0);
        }

        // 1. Prioritize agents with a relationship to the trustor
        List<String> withRel = decisiveAgents.stream()
            .filter(a -> beliefBaseInstance.getRelationshipType(trustor, a) != null)
            .collect(Collectors.toList());
        List<String> pool = !withRel.isEmpty() ? withRel : decisiveAgents;

        // 2. Max similarity (to goal or trustor)
        List<Double> goalVec = beliefBaseInstance.getGoalVector(goal);
        List<Double> trustorVec = beliefBaseInstance.getTrustorVector(trustor, goal);
        double maxSim = pool.stream()
            .map(a -> {
                List<Double> agentVec = beliefBaseInstance.getAgentVector(a, goal);
                double simGoal = CosineSimilarity.calculate(agentVec, goalVec);
                double simTrustor = CosineSimilarity.calculate(agentVec, trustorVec);
                return Math.max(simGoal, simTrustor);
            })
            .max(Double::compareTo)
            .orElse(Double.NEGATIVE_INFINITY);
        List<String> maxSimAgents = pool.stream()
            .filter(a -> {
                List<Double> agentVec = beliefBaseInstance.getAgentVector(a, goal);
                double simGoal = CosineSimilarity.calculate(agentVec, goalVec);
                double simTrustor = CosineSimilarity.calculate(agentVec, trustorVec);
                return Math.max(simGoal, simTrustor) == maxSim;
            })
            .collect(Collectors.toList());
        if (maxSimAgents.size() == 1) return maxSimAgents.get(0);

        // 3. Max relationship strength
        double maxStrength = maxSimAgents.stream()
            .map(a -> beliefBaseInstance.getRelationshipStrength(trustor, a))
            .filter(Objects::nonNull)
            .max(Double::compareTo)
            .orElse(Double.NEGATIVE_INFINITY);
        List<String> maxStrengthAgents = maxSimAgents.stream()
            .filter(a -> {
                Double s = beliefBaseInstance.getRelationshipStrength(trustor, a);
                return s != null && s == maxStrength;
            })
            .collect(Collectors.toList());
        if (maxStrengthAgents.size() == 1) return maxStrengthAgents.get(0);

        // 4. Benevolence (maximize)
        List<ScoreAgentPair> benScores = maxStrengthAgents.stream()
            .map(a -> new ScoreAgentPair(
                beliefBaseInstance.getBenevolenceScore(a, goal) != null ? beliefBaseInstance.getBenevolenceScore(a, goal) : 0.0, a))
            .collect(Collectors.toList());
        List<String> maxBen = findAgentsWithMaxScore(benScores);
        if (maxBen.size() == 1) return maxBen.get(0);

        // 5. Incompetence (minimize)
        List<ScoreAgentPair> incompScores = maxBen.stream()
            .map(a -> new ScoreAgentPair(
                beliefBaseInstance.getIncompetenceScore(a, goal) != null ? beliefBaseInstance.getIncompetenceScore(a, goal) : Double.MAX_VALUE, a))
            .collect(Collectors.toList());
        List<String> minIncomp = findAgentsWithMinScore(incompScores);
        if (minIncomp.size() == 1) return minIncomp.get(0);

        // 6. Final tie-breaker: trustworthiness or untrustworthiness
        if (isUntrustworthy) {
            List<ScoreAgentPair> uscores = minIncomp.stream()
                .map(a -> new ScoreAgentPair(
                    beliefBaseInstance.getUntrustworthinessScore(a, goal) != null ? beliefBaseInstance.getUntrustworthinessScore(a, goal) : Double.MAX_VALUE, a))
                .collect(Collectors.toList());
            List<String> minUscore = findAgentsWithMinScore(uscores);
            if (!minUscore.isEmpty()) return minUscore.get(0);
        } else {
            List<ScoreAgentPair> tscores = minIncomp.stream()
                .map(a -> new ScoreAgentPair(
                    beliefBaseInstance.getTrustworthinessScore(a, goal) != null ? beliefBaseInstance.getTrustworthinessScore(a, goal) : 0.0, a))
                .collect(Collectors.toList());
            List<String> maxTscore = findAgentsWithMaxScore(tscores);
            if (!maxTscore.isEmpty()) return maxTscore.get(0);
        }

        return "none_found_final_tie_break";
    }

    // --- Relationship similarity stub (can be extended for more complex logic) ---
    public static List<String> decisiveRelationshipSimilarity(String goal, String trustor, List<String> candidates) {
        return candidates == null ? new ArrayList<>() : new ArrayList<>(candidates);
    }

    // --- Find agents with the minimum score in a list ---
    public static  List<String> findAgentsWithMinScore(List<ScoreAgentPair> scoreAgentList) {
        if (scoreAgentList == null || scoreAgentList.isEmpty()) {
            return new ArrayList<>();
        }
        double minScore = scoreAgentList.get(0).getScore();
        for (ScoreAgentPair item : scoreAgentList) {
            if (item.getScore() < minScore) {
                minScore = item.getScore();
            }
        }
        final double finalMinScore = minScore;
        return scoreAgentList.stream()
                .filter(item -> item.getScore() == finalMinScore)
                .map(ScoreAgentPair::getAgent)
                .collect(Collectors.toList());
    }

    // --- Find agents with the maximum score in a list ---
    public static List<String> findAgentsWithMaxScore(List<ScoreAgentPair> scoreAgentList) {
        if (scoreAgentList == null || scoreAgentList.isEmpty()) {
            return new ArrayList<>();
        }
        double maxScore = scoreAgentList.get(0).getScore();
        for (ScoreAgentPair item : scoreAgentList) {
            if (item.getScore() > maxScore) {
                maxScore = item.getScore();
            }
        }
        final double finalMaxScore = maxScore;
        return scoreAgentList.stream()
                .filter(item -> item.getScore() == finalMaxScore)
                .map(ScoreAgentPair::getAgent)
                .collect(Collectors.toList());
    }
}

