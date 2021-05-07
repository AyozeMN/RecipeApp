package gui;

import file.CategoriesFile;
import file.IngredientsFile;
import file.NotFinalCategoryFile;
import file.RecipeFile;
import file.UsersFile;
import file.ValorationsFile;
import java.awt.CardLayout;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import model.Admin;
import model.Category;
import model.Client;
import model.FinalCategory;
import model.Ingredient;
import model.Menu;
import model.NotFinalCategory;
import model.Recipe;
import model.User;

public class AppForm extends javax.swing.JFrame {

    public IngredientsFile ingredientsFile = new IngredientsFile();
    public CategoriesFile categoriesFile = new CategoriesFile();
    public NotFinalCategoryFile notFinalCategoryFile = new NotFinalCategoryFile();
    public RecipeFile recipeFile = new RecipeFile();
    public UsersFile usersFile = new UsersFile();
    public ValorationsFile valorationsFile = new ValorationsFile();
    
    //public ArrayList<User>users = new ArrayList();
    private User loggedUser;
    
    private CardLayout cardLayout = new CardLayout();

    private ArrayList<Ingredient>ingredients;
    private ArrayList<FinalCategory>finalCategories;
    private ArrayList<NotFinalCategory>notFinalCategories;
    private ArrayList<User>users;
    private int[] selected;
        
    private final DefaultListModel ingredientsModel = new DefaultListModel();
    private final DefaultListModel notFinalCategoriesModel = new DefaultListModel();
    private final DefaultListModel finalCategoriesModel = new DefaultListModel();
    private final DefaultListModel recipeFoundModel = new DefaultListModel();
    private final DefaultListModel myRecipesToAddToMenuModel = new DefaultListModel();
    private final DefaultListModel myRecipesModel = new DefaultListModel();
    private final DefaultListModel myMenusModel = new DefaultListModel();
    private final DefaultListModel recipeToRateModel = new DefaultListModel();
    private final DefaultComboBoxModel filterModel = new DefaultComboBoxModel();
     
    private void initIngredientsList(){
        for (Ingredient ingredient : ingredients) {
            ingredientsModel.addElement(ingredient);
        }
    }
    
    private void initSearchList(){
        recipeFoundModel.clear();
        recipeFile.loadFromFile(users);
        valorationsFile.loadFromFile(users);
        for (User user : users) {
            for (Recipe recipe : user.getRecipes()) {
                recipeFoundModel.addElement(user.getUserName() + ": " + recipe);
            }
        }
    }
    
    private void clearModels(){
        recipeFoundModel.clear();
        myRecipesToAddToMenuModel.clear();
        myRecipesModel.clear();
        myMenusModel.clear();
        recipeToRateModel.clear();
    }
    
    private void initSelectedCategories(){
        for (int i = 0; i < selected.length; i++) {
            selected[i] = 0;
        }
    }
    
    private void initNotFinalCategoriesList(){
        for (NotFinalCategory notFinalCategory : notFinalCategories) {
            notFinalCategoriesModel.addElement(notFinalCategory);
        }
    }
    
    /*private void initFinalCategoriesList(){
        for (FinalCategory category : finalCategories) {
            notFinalCategoriesModel.addElement(category);
        }
    }*/
    
    private void setMyRecipes(){
        myRecipesModel.clear();
        if(loggedUser != null){
            for (Recipe recipe : loggedUser.getRecipes()) {
                myRecipesModel.addElement(recipe);
            }
        }
    }
    
    private void initFiltersComboBox(){
        for (NotFinalCategory notFinalCategory : notFinalCategories) {
            filterModel.addElement(notFinalCategory);
            for (FinalCategory subCategory : notFinalCategory.getSubCategories()) {
                filterModel.addElement(subCategory);
            }
        }
    }
    
    public AppForm() {
        this.ingredients = new ArrayList();
        this.finalCategories = new ArrayList();
        this.notFinalCategories = new ArrayList();
        this.users = new ArrayList();
                
        initComponents();
       
        ingredientsList.setModel(ingredientsModel);
        notFinalCategoriesList.setModel(notFinalCategoriesModel);
        finalCategoriesList.setModel(finalCategoriesModel);
        recipesFoundList.setModel(recipeFoundModel);
        myRecipesToAddToMenuList.setModel(myRecipesToAddToMenuModel);
        myRecipesList.setModel(myRecipesModel);
        myMenusList.setModel(myMenusModel);
        filters.setModel(filterModel);
        
        ingredientsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        notFinalCategoriesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        myRecipesToAddToMenuList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        usersFile.loadFromFile(users);
        ingredientsFile.loadFromFile(ingredients);
        categoriesFile.loadFromFile(finalCategories);
        notFinalCategoryFile.loadFromFile(notFinalCategories);
        
        this.selected = new int[notFinalCategories.size()];
        
        initSelectedCategories();
        initIngredientsList();
//        initFinalCategoriesList();
        initNotFinalCategoriesList();
        initFiltersComboBox();
        initSearchList();
        
        super.setSize(1280, 720);
        
        credentialsWrongLabel.setVisible(false);
        rateErrorLabel.setVisible(false);
        recipeWrongLabel.setVisible(false);
        adminRemoveRecipeButton.setVisible(false);
        adminRemoveRecipeButton.setEnabled(false);

        
        cardLayout = (CardLayout) jPanelCard.getLayout();
        jPanelCard.setLayout(cardLayout);
        
        //Botones del menu disponibles
        logInButton.setEnabled(true);
        createRecipeButton.setEnabled(false);
        createMenuButton.setEnabled(false);
        searchRecipeButton.setEnabled(false);
        myRecipesButton.setEnabled(false);
        logOutButton.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPanel = new javax.swing.JSplitPane();
        jPanelCard = new javax.swing.JPanel();
        logInPanel = new javax.swing.JPanel();
        logInTittlePanel = new javax.swing.JPanel();
        logInTittlePanelLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameTextArea = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        logInUserButton = new javax.swing.JButton();
        credentialsWrongLabel = new javax.swing.JLabel();
        recipePanel = new javax.swing.JPanel();
        recipeTittlePanel = new javax.swing.JPanel();
        recipeTittlePanelLabel = new javax.swing.JLabel();
        nameRecipeLabel = new javax.swing.JLabel();
        recipeNameText = new javax.swing.JTextField();
        stepsLabel = new javax.swing.JLabel();
        stepsScrollPane = new javax.swing.JScrollPane();
        stepsTextArea = new javax.swing.JTextArea();
        cookTimeLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        ingredientsLabel = new javax.swing.JLabel();
        ingredientsScrollPane = new javax.swing.JScrollPane();
        ingredientsList = new javax.swing.JList<>();
        categoriesLabel = new javax.swing.JLabel();
        categoriesScrollPane = new javax.swing.JScrollPane();
        notFinalCategoriesList = new javax.swing.JList<>();
        createRecipe = new javax.swing.JButton();
        resetRecipe = new javax.swing.JButton();
        cookTime = new lu.tudor.santec.jtimechooser.JTimeChooser();
        recipeWrongLabel = new javax.swing.JLabel();
        categoriesScrollPane1 = new javax.swing.JScrollPane();
        finalCategoriesList = new javax.swing.JList<>();
        recipePrice = new javax.swing.JLabel();
        myRecipesPanel = new javax.swing.JPanel();
        logInTittlePanel1 = new javax.swing.JPanel();
        logInTittlePanelLabel1 = new javax.swing.JLabel();
        myRecipesScrollBar = new javax.swing.JScrollPane();
        myRecipesList = new javax.swing.JList<>();
        removeRecipeButton = new javax.swing.JButton();
        searhRecipePanel = new javax.swing.JPanel();
        searchRecipeTittlePanel = new javax.swing.JPanel();
        searchTittleLPanelLabel = new javax.swing.JLabel();
        filters = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
        recipeNameToSearch = new javax.swing.JTextField();
        categoriesFilterSearchLabel = new javax.swing.JLabel();
        recipeNameSearchLabel = new javax.swing.JLabel();
        recipesFoundComboBox = new javax.swing.JScrollPane();
        recipesFoundList = new javax.swing.JList<>();
        rateErrorLabel = new javax.swing.JLabel();
        rateOrRemoveButton = new javax.swing.JButton();
        adminRemoveRecipeButton = new javax.swing.JButton();
        rateRecipesPanel = new javax.swing.JPanel();
        rateRecipesTittlePanel = new javax.swing.JPanel();
        rateTittleLPanelLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectedRecipeToRateList = new javax.swing.JList<>();
        rateValueSpinner = new javax.swing.JSpinner();
        rateRecipeButton = new javax.swing.JButton();
        backButton3 = new javax.swing.JButton();
        ratedMessage = new javax.swing.JLabel();
        createMenuPanel = new javax.swing.JPanel();
        createMenuTittlePanel = new javax.swing.JPanel();
        createMenuTittleLPanelLabel = new javax.swing.JLabel();
        myRecipesToAddToMenuScrollBar = new javax.swing.JScrollPane();
        myRecipesToAddToMenuList = new javax.swing.JList<>();
        addMenuButton = new javax.swing.JButton();
        recipesLabel = new javax.swing.JLabel();
        menusLabel = new javax.swing.JLabel();
        removeMenuButton = new javax.swing.JButton();
        myMenusScrollBar = new javax.swing.JScrollPane();
        myMenusList = new javax.swing.JList<>();
        menuName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        logInButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        createRecipeButton = new javax.swing.JButton();
        createMenuButton = new javax.swing.JButton();
        searchRecipeButton = new javax.swing.JButton();
        myRecipesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 846));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 848));

        jSplitPanel.setMaximumSize(new java.awt.Dimension(1280, 848));
        jSplitPanel.setMinimumSize(new java.awt.Dimension(1280, 848));
        jSplitPanel.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanelCard.setBackground(new java.awt.Color(203, 241, 245));
        jPanelCard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelCard.setMaximumSize(new java.awt.Dimension(1000, 846));
        jPanelCard.setMinimumSize(new java.awt.Dimension(1000, 846));
        jPanelCard.setPreferredSize(new java.awt.Dimension(1000, 846));
        jPanelCard.setLayout(new java.awt.CardLayout());

        logInPanel.setBackground(new java.awt.Color(57, 62, 70));
        logInPanel.setPreferredSize(new java.awt.Dimension(1006, 848));

        logInTittlePanel.setBackground(new java.awt.Color(78, 204, 163));

        logInTittlePanelLabel.setBackground(new java.awt.Color(78, 204, 163));
        logInTittlePanelLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        logInTittlePanelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logInTittlePanelLabel.setText("Log Into the app");

        javax.swing.GroupLayout logInTittlePanelLayout = new javax.swing.GroupLayout(logInTittlePanel);
        logInTittlePanel.setLayout(logInTittlePanelLayout);
        logInTittlePanelLayout.setHorizontalGroup(
            logInTittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logInTittlePanelLayout.createSequentialGroup()
                .addComponent(logInTittlePanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        logInTittlePanelLayout.setVerticalGroup(
            logInTittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logInTittlePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logInTittlePanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        usernameLabel.setForeground(new java.awt.Color(238, 238, 238));
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("USERNAME");

        usernameTextArea.setBackground(new java.awt.Color(35, 41, 49));
        usernameTextArea.setForeground(new java.awt.Color(238, 238, 238));

        passwordLabel.setForeground(new java.awt.Color(238, 238, 238));
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("PASSWORD");

        passwordField.setBackground(new java.awt.Color(35, 41, 49));
        passwordField.setForeground(new java.awt.Color(238, 238, 238));

        logInUserButton.setBackground(new java.awt.Color(78, 204, 163));
        logInUserButton.setForeground(new java.awt.Color(238, 238, 238));
        logInUserButton.setText("Log in");
        logInUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInUserButtonActionPerformed(evt);
            }
        });

        credentialsWrongLabel.setForeground(new java.awt.Color(255, 0, 0));
        credentialsWrongLabel.setText("Credentials not founded, try again.");

        javax.swing.GroupLayout logInPanelLayout = new javax.swing.GroupLayout(logInPanel);
        logInPanel.setLayout(logInPanelLayout);
        logInPanelLayout.setHorizontalGroup(
            logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(logInPanelLayout.createSequentialGroup()
                .addComponent(logInTittlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logInPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logInUserButton)
                .addGap(465, 465, 465))
            .addGroup(logInPanelLayout.createSequentialGroup()
                .addGap(419, 419, 419)
                .addGroup(logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logInPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(credentialsWrongLabel)
                .addGap(400, 400, 400))
        );
        logInPanelLayout.setVerticalGroup(
            logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logInPanelLayout.createSequentialGroup()
                .addComponent(logInTittlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(usernameLabel)
                .addGap(18, 18, 18)
                .addComponent(usernameTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logInUserButton)
                .addGap(34, 34, 34)
                .addComponent(credentialsWrongLabel)
                .addContainerGap(473, Short.MAX_VALUE))
        );

        jPanelCard.add(logInPanel, "logInCard");

        recipePanel.setBackground(new java.awt.Color(57, 62, 70));
        recipePanel.setPreferredSize(new java.awt.Dimension(710, 848));

        recipeTittlePanel.setBackground(new java.awt.Color(78, 204, 163));

        recipeTittlePanelLabel.setBackground(new java.awt.Color(78, 204, 163));
        recipeTittlePanelLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        recipeTittlePanelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recipeTittlePanelLabel.setText("Create your own Recipe");

        javax.swing.GroupLayout recipeTittlePanelLayout = new javax.swing.GroupLayout(recipeTittlePanel);
        recipeTittlePanel.setLayout(recipeTittlePanelLayout);
        recipeTittlePanelLayout.setHorizontalGroup(
            recipeTittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recipeTittlePanelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        recipeTittlePanelLayout.setVerticalGroup(
            recipeTittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recipeTittlePanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        nameRecipeLabel.setBackground(new java.awt.Color(238, 238, 238));
        nameRecipeLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        nameRecipeLabel.setForeground(new java.awt.Color(238, 238, 238));
        nameRecipeLabel.setText("Name:");

        recipeNameText.setBackground(new java.awt.Color(35, 41, 49));
        recipeNameText.setForeground(new java.awt.Color(238, 238, 238));

        stepsLabel.setBackground(new java.awt.Color(238, 238, 238));
        stepsLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        stepsLabel.setForeground(new java.awt.Color(238, 238, 238));
        stepsLabel.setText("Steps:");

        stepsTextArea.setBackground(new java.awt.Color(35, 41, 49));
        stepsTextArea.setColumns(20);
        stepsTextArea.setForeground(new java.awt.Color(238, 238, 238));
        stepsTextArea.setRows(5);
        stepsScrollPane.setViewportView(stepsTextArea);

        cookTimeLabel.setBackground(new java.awt.Color(238, 238, 238));
        cookTimeLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        cookTimeLabel.setForeground(new java.awt.Color(238, 238, 238));
        cookTimeLabel.setText("Cook time:");

        priceLabel.setBackground(new java.awt.Color(238, 238, 238));
        priceLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(238, 238, 238));
        priceLabel.setText("Price:");

        ingredientsLabel.setBackground(new java.awt.Color(238, 238, 238));
        ingredientsLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        ingredientsLabel.setForeground(new java.awt.Color(238, 238, 238));
        ingredientsLabel.setText("Ingredients:");

        ingredientsList.setBackground(new java.awt.Color(35, 41, 49));
        ingredientsList.setForeground(new java.awt.Color(238, 238, 238));
        ingredientsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingredientsListMouseClicked(evt);
            }
        });
        ingredientsScrollPane.setViewportView(ingredientsList);

        categoriesLabel.setBackground(new java.awt.Color(238, 238, 238));
        categoriesLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        categoriesLabel.setForeground(new java.awt.Color(238, 238, 238));
        categoriesLabel.setText("Categories:");

        notFinalCategoriesList.setBackground(new java.awt.Color(35, 41, 49));
        notFinalCategoriesList.setForeground(new java.awt.Color(238, 238, 238));
        notFinalCategoriesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notFinalCategoriesListMouseClicked(evt);
            }
        });
        categoriesScrollPane.setViewportView(notFinalCategoriesList);

        createRecipe.setBackground(new java.awt.Color(78, 204, 163));
        createRecipe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createRecipe.setForeground(new java.awt.Color(238, 238, 238));
        createRecipe.setText("Create");
        createRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRecipeActionPerformed(evt);
            }
        });

        resetRecipe.setBackground(new java.awt.Color(78, 204, 163));
        resetRecipe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resetRecipe.setForeground(new java.awt.Color(238, 238, 238));
        resetRecipe.setText("Reset");
        resetRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetRecipeActionPerformed(evt);
            }
        });

        recipeWrongLabel.setForeground(new java.awt.Color(255, 0, 0));
        recipeWrongLabel.setText("Recipe already exists");

        finalCategoriesList.setBackground(new java.awt.Color(35, 41, 49));
        finalCategoriesList.setForeground(new java.awt.Color(238, 238, 238));
        categoriesScrollPane1.setViewportView(finalCategoriesList);

        recipePrice.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout recipePanelLayout = new javax.swing.GroupLayout(recipePanel);
        recipePanel.setLayout(recipePanelLayout);
        recipePanelLayout.setHorizontalGroup(
            recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recipeTittlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(recipePanelLayout.createSequentialGroup()
                .addContainerGap(293, Short.MAX_VALUE)
                .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingredientsLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cookTimeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(stepsLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameRecipeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(priceLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(categoriesLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recipePanelLayout.createSequentialGroup()
                        .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recipeWrongLabel)
                            .addComponent(recipeNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stepsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(recipePanelLayout.createSequentialGroup()
                                .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, recipePanelLayout.createSequentialGroup()
                                        .addComponent(createRecipe)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(resetRecipe))
                                    .addComponent(categoriesScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ingredientsScrollPane, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(categoriesScrollPane1))
                            .addComponent(cookTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86))
                    .addGroup(recipePanelLayout.createSequentialGroup()
                        .addComponent(recipePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        recipePanelLayout.setVerticalGroup(
            recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recipePanelLayout.createSequentialGroup()
                .addComponent(recipeTittlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameRecipeLabel)
                    .addComponent(recipeNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stepsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stepsLabel))
                .addGap(18, 18, 18)
                .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cookTimeLabel)
                    .addComponent(cookTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(priceLabel)
                    .addGroup(recipePanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(recipePrice, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingredientsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingredientsLabel))
                .addGap(18, 18, 18)
                .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recipePanelLayout.createSequentialGroup()
                        .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoriesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoriesScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recipeWrongLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(recipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetRecipe)
                            .addComponent(createRecipe)))
                    .addComponent(categoriesLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCard.add(recipePanel, "recipeCard");

        myRecipesPanel.setBackground(new java.awt.Color(57, 62, 70));
        myRecipesPanel.setPreferredSize(new java.awt.Dimension(1006, 848));

        logInTittlePanel1.setBackground(new java.awt.Color(78, 204, 163));

        logInTittlePanelLabel1.setBackground(new java.awt.Color(78, 204, 163));
        logInTittlePanelLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        logInTittlePanelLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logInTittlePanelLabel1.setText("My Recipes");

        javax.swing.GroupLayout logInTittlePanel1Layout = new javax.swing.GroupLayout(logInTittlePanel1);
        logInTittlePanel1.setLayout(logInTittlePanel1Layout);
        logInTittlePanel1Layout.setHorizontalGroup(
            logInTittlePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logInTittlePanel1Layout.createSequentialGroup()
                .addComponent(logInTittlePanelLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        logInTittlePanel1Layout.setVerticalGroup(
            logInTittlePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logInTittlePanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logInTittlePanelLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        myRecipesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myRecipesListMouseClicked(evt);
            }
        });
        myRecipesScrollBar.setViewportView(myRecipesList);

        removeRecipeButton.setBackground(new java.awt.Color(78, 204, 163));
        removeRecipeButton.setForeground(new java.awt.Color(238, 238, 238));
        removeRecipeButton.setText("Remove recipe");
        removeRecipeButton.setEnabled(false);
        removeRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRecipeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myRecipesPanelLayout = new javax.swing.GroupLayout(myRecipesPanel);
        myRecipesPanel.setLayout(myRecipesPanelLayout);
        myRecipesPanelLayout.setHorizontalGroup(
            myRecipesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myRecipesPanelLayout.createSequentialGroup()
                .addComponent(logInTittlePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(myRecipesPanelLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(myRecipesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(removeRecipeButton)
                    .addComponent(myRecipesScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        myRecipesPanelLayout.setVerticalGroup(
            myRecipesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myRecipesPanelLayout.createSequentialGroup()
                .addComponent(logInTittlePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(myRecipesScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeRecipeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCard.add(myRecipesPanel, "myRecipesCard");

        searhRecipePanel.setBackground(new java.awt.Color(57, 62, 70));
        searhRecipePanel.setPreferredSize(new java.awt.Dimension(1006, 848));

        searchRecipeTittlePanel.setBackground(new java.awt.Color(78, 204, 163));

        searchTittleLPanelLabel.setBackground(new java.awt.Color(78, 204, 163));
        searchTittleLPanelLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        searchTittleLPanelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchTittleLPanelLabel.setText("Search Recipes");

        javax.swing.GroupLayout searchRecipeTittlePanelLayout = new javax.swing.GroupLayout(searchRecipeTittlePanel);
        searchRecipeTittlePanel.setLayout(searchRecipeTittlePanelLayout);
        searchRecipeTittlePanelLayout.setHorizontalGroup(
            searchRecipeTittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchRecipeTittlePanelLayout.createSequentialGroup()
                .addComponent(searchTittleLPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        searchRecipeTittlePanelLayout.setVerticalGroup(
            searchRecipeTittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchRecipeTittlePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(searchTittleLPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        searchButton.setBackground(new java.awt.Color(78, 204, 163));
        searchButton.setForeground(new java.awt.Color(238, 238, 238));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        categoriesFilterSearchLabel.setForeground(new java.awt.Color(238, 238, 238));
        categoriesFilterSearchLabel.setText("Categories:");

        recipeNameSearchLabel.setForeground(new java.awt.Color(238, 238, 238));
        recipeNameSearchLabel.setText("Recipe name:");

        recipesFoundList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        recipesFoundList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recipesFoundListMouseClicked(evt);
            }
        });
        recipesFoundComboBox.setViewportView(recipesFoundList);

        rateErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        rateErrorLabel.setText("You have to select one recipe to rate it.");

        rateOrRemoveButton.setText("Rate");
        rateOrRemoveButton.setEnabled(false);
        rateOrRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateOrRemoveButtonActionPerformed(evt);
            }
        });

        adminRemoveRecipeButton.setText("Remove");
        adminRemoveRecipeButton.setEnabled(false);
        adminRemoveRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminRemoveRecipeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searhRecipePanelLayout = new javax.swing.GroupLayout(searhRecipePanel);
        searhRecipePanel.setLayout(searhRecipePanelLayout);
        searhRecipePanelLayout.setHorizontalGroup(
            searhRecipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searhRecipePanelLayout.createSequentialGroup()
                .addComponent(searchRecipeTittlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(searhRecipePanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(searhRecipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rateErrorLabel)
                    .addGroup(searhRecipePanelLayout.createSequentialGroup()
                        .addComponent(recipeNameSearchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recipeNameToSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(categoriesFilterSearchLabel)
                        .addGap(18, 18, 18)
                        .addComponent(filters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searhRecipePanelLayout.createSequentialGroup()
                        .addComponent(recipesFoundComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(searhRecipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rateOrRemoveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(adminRemoveRecipeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        searhRecipePanelLayout.setVerticalGroup(
            searhRecipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searhRecipePanelLayout.createSequentialGroup()
                .addComponent(searchRecipeTittlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(rateErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(searhRecipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(recipeNameToSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoriesFilterSearchLabel)
                    .addComponent(recipeNameSearchLabel))
                .addGap(18, 18, 18)
                .addGroup(searhRecipePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recipesFoundComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(searhRecipePanelLayout.createSequentialGroup()
                        .addComponent(rateOrRemoveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adminRemoveRecipeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCard.add(searhRecipePanel, "searchRecipesCard");

        rateRecipesPanel.setBackground(new java.awt.Color(57, 62, 70));
        rateRecipesPanel.setPreferredSize(new java.awt.Dimension(1006, 848));

        rateRecipesTittlePanel.setBackground(new java.awt.Color(78, 204, 163));

        rateTittleLPanelLabel.setBackground(new java.awt.Color(78, 204, 163));
        rateTittleLPanelLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        rateTittleLPanelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rateTittleLPanelLabel.setText("Rate the selected Recipe");

        javax.swing.GroupLayout rateRecipesTittlePanelLayout = new javax.swing.GroupLayout(rateRecipesTittlePanel);
        rateRecipesTittlePanel.setLayout(rateRecipesTittlePanelLayout);
        rateRecipesTittlePanelLayout.setHorizontalGroup(
            rateRecipesTittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rateRecipesTittlePanelLayout.createSequentialGroup()
                .addComponent(rateTittleLPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        rateRecipesTittlePanelLayout.setVerticalGroup(
            rateRecipesTittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rateRecipesTittlePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rateTittleLPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        selectedRecipeToRateList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(selectedRecipeToRateList);

        rateValueSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        rateValueSpinner.setValue(5);

        rateRecipeButton.setBackground(new java.awt.Color(78, 204, 163));
        rateRecipeButton.setForeground(new java.awt.Color(238, 238, 238));
        rateRecipeButton.setText("Rate");
        rateRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateRecipeButtonActionPerformed(evt);
            }
        });

        backButton3.setForeground(new java.awt.Color(255, 255, 255));
        backButton3.setText("<  Back");
        backButton3.setToolTipText("");
        backButton3.setBorderPainted(false);
        backButton3.setContentAreaFilled(false);
        backButton3.setFocusCycleRoot(true);
        backButton3.setFocusPainted(false);
        backButton3.setFocusable(false);

        ratedMessage.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout rateRecipesPanelLayout = new javax.swing.GroupLayout(rateRecipesPanel);
        rateRecipesPanel.setLayout(rateRecipesPanelLayout);
        rateRecipesPanelLayout.setHorizontalGroup(
            rateRecipesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rateRecipesPanelLayout.createSequentialGroup()
                .addComponent(rateRecipesTittlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(rateRecipesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rateRecipesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rateRecipesPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rateValueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rateRecipeButton))
                    .addGroup(rateRecipesPanelLayout.createSequentialGroup()
                        .addGroup(rateRecipesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ratedMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backButton3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rateRecipesPanelLayout.setVerticalGroup(
            rateRecipesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rateRecipesPanelLayout.createSequentialGroup()
                .addComponent(rateRecipesTittlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(backButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rateRecipesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rateRecipesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rateValueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rateRecipeButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ratedMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(523, Short.MAX_VALUE))
        );

        jPanelCard.add(rateRecipesPanel, "rateRecipesCard");

        createMenuPanel.setBackground(new java.awt.Color(57, 62, 70));
        createMenuPanel.setPreferredSize(new java.awt.Dimension(1006, 848));

        createMenuTittlePanel.setBackground(new java.awt.Color(78, 204, 163));

        createMenuTittleLPanelLabel.setBackground(new java.awt.Color(78, 204, 163));
        createMenuTittleLPanelLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        createMenuTittleLPanelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createMenuTittleLPanelLabel.setText("Create your own Menu");

        javax.swing.GroupLayout createMenuTittlePanelLayout = new javax.swing.GroupLayout(createMenuTittlePanel);
        createMenuTittlePanel.setLayout(createMenuTittlePanelLayout);
        createMenuTittlePanelLayout.setHorizontalGroup(
            createMenuTittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createMenuTittlePanelLayout.createSequentialGroup()
                .addComponent(createMenuTittleLPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        createMenuTittlePanelLayout.setVerticalGroup(
            createMenuTittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createMenuTittlePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(createMenuTittleLPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        myRecipesToAddToMenuList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myRecipesToAddToMenuListMouseClicked(evt);
            }
        });
        myRecipesToAddToMenuScrollBar.setViewportView(myRecipesToAddToMenuList);

        addMenuButton.setBackground(new java.awt.Color(78, 204, 163));
        addMenuButton.setForeground(new java.awt.Color(238, 238, 238));
        addMenuButton.setText("Create menu");
        addMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenuButtonActionPerformed(evt);
            }
        });

        recipesLabel.setForeground(new java.awt.Color(255, 255, 255));
        recipesLabel.setText("Recipes");

        menusLabel.setForeground(new java.awt.Color(255, 255, 255));
        menusLabel.setText("Menus");

        removeMenuButton.setBackground(new java.awt.Color(78, 204, 163));
        removeMenuButton.setForeground(new java.awt.Color(238, 238, 238));
        removeMenuButton.setText("Remove menu");
        removeMenuButton.setEnabled(false);
        removeMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMenuButtonActionPerformed(evt);
            }
        });

        myMenusList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myMenusListMouseClicked(evt);
            }
        });
        myMenusScrollBar.setViewportView(myMenusList);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Menu name:");

        javax.swing.GroupLayout createMenuPanelLayout = new javax.swing.GroupLayout(createMenuPanel);
        createMenuPanel.setLayout(createMenuPanelLayout);
        createMenuPanelLayout.setHorizontalGroup(
            createMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createMenuPanelLayout.createSequentialGroup()
                .addComponent(createMenuTittlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(createMenuPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(createMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(createMenuPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(58, 58, 58)
                        .addComponent(menuName))
                    .addComponent(recipesLabel)
                    .addComponent(myRecipesToAddToMenuScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMenuButton))
                .addGap(161, 161, 161)
                .addGroup(createMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeMenuButton)
                    .addComponent(menusLabel)
                    .addComponent(myMenusScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        createMenuPanelLayout.setVerticalGroup(
            createMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createMenuPanelLayout.createSequentialGroup()
                .addComponent(createMenuTittlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(createMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recipesLabel)
                    .addComponent(menusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myRecipesToAddToMenuScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myMenusScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeMenuButton)
                    .addComponent(menuName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addComponent(addMenuButton)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        jPanelCard.add(createMenuPanel, "menuCard");

        jSplitPanel.setLeftComponent(jPanelCard);

        buttonsPanel.setBackground(new java.awt.Color(238, 238, 238));

        logInButton.setBackground(new java.awt.Color(78, 204, 163));
        logInButton.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        logInButton.setForeground(new java.awt.Color(57, 62, 70));
        logInButton.setText("Log In");
        logInButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });

        logOutButton.setBackground(new java.awt.Color(78, 204, 163));
        logOutButton.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(57, 62, 70));
        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        createRecipeButton.setBackground(new java.awt.Color(78, 204, 163));
        createRecipeButton.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        createRecipeButton.setForeground(new java.awt.Color(57, 62, 70));
        createRecipeButton.setText("New Recipe");
        createRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRecipeButtonActionPerformed(evt);
            }
        });

        createMenuButton.setBackground(new java.awt.Color(78, 204, 163));
        createMenuButton.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        createMenuButton.setForeground(new java.awt.Color(57, 62, 70));
        createMenuButton.setText("New Menu");
        createMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createMenuButtonActionPerformed(evt);
            }
        });

        searchRecipeButton.setBackground(new java.awt.Color(78, 204, 163));
        searchRecipeButton.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        searchRecipeButton.setForeground(new java.awt.Color(57, 62, 70));
        searchRecipeButton.setText("Search Recipes");
        searchRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRecipeButtonActionPerformed(evt);
            }
        });

        myRecipesButton.setBackground(new java.awt.Color(78, 204, 163));
        myRecipesButton.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        myRecipesButton.setForeground(new java.awt.Color(57, 62, 70));
        myRecipesButton.setText("My recipes");
        myRecipesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myRecipesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myRecipesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(searchRecipeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createMenuButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createRecipeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logInButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logOutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myRecipesButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(logInButton)
                .addGap(18, 18, 18)
                .addComponent(createRecipeButton)
                .addGap(18, 18, 18)
                .addComponent(createMenuButton)
                .addGap(18, 18, 18)
                .addComponent(searchRecipeButton)
                .addGap(18, 18, 18)
                .addComponent(myRecipesButton)
                .addGap(18, 18, 18)
                .addComponent(logOutButton)
                .addGap(394, 394, 394))
        );

        jSplitPanel.setRightComponent(buttonsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        clearLogIn();
        cardLayout.show(jPanelCard, "logInCard");
    }//GEN-LAST:event_logInButtonActionPerformed

    private void clearLogIn() {
        usernameTextArea.setText("");
        passwordField.setText("");
    }

    private void createRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRecipeButtonActionPerformed
        clearRecipe();
        recipeWrongLabel.setVisible(false);
        cardLayout.show(jPanelCard, "recipeCard");
        initSelectedCategories();
    }//GEN-LAST:event_createRecipeButtonActionPerformed

    private void createRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRecipeActionPerformed
                
        String name = recipeNameText.getText();
        String steps = stepsTextArea.getText();
        LocalTime localTime = LocalTime.of(cookTime.getHours(), cookTime.getMinutes());
        double price = 0;       
        int[] ingredientsIndices = ingredientsList.getSelectedIndices();
        int[] categoriesIndices = notFinalCategoriesList.getSelectedIndices();      
        
        if(!name.equals("") && !steps.equals("") && localTime.compareTo(LocalTime.parse("00:01:00"))>0 && ingredientsIndices.length>=1 && categoriesIndices.length>=1) {
            recipeWrongLabel.setVisible(false);
            ArrayList<Ingredient>recipeIngredients = new ArrayList();
            for (int ingredientsIndex : ingredientsIndices) {
                recipeIngredients.add((Ingredient) ingredientsModel.getElementAt(ingredientsIndex));
                price += ((Ingredient) ingredientsModel.getElementAt(ingredientsIndex)).getPrice();
            }

            ArrayList<Category>recipeCategories = new ArrayList();
            for (int categoriesIndex : categoriesIndices) {
                recipeCategories.add((NotFinalCategory)notFinalCategoriesModel.getElementAt(categoriesIndex));
            }
            for (int selectedIndex : finalCategoriesList.getSelectedIndices()) {
                recipeCategories.add((FinalCategory) finalCategoriesModel.getElementAt(selectedIndex));
            }
            Recipe recipe = new Recipe(name, steps, price, localTime, recipeIngredients, recipeCategories);
            if(!loggedUser.addRecipe(recipe)) recipeWrongLabel.setVisible(true);
            else{
                cardLayout.show(jPanelCard, "myRecipesCard");
                setMyRecipes();
            }
    //        recipeFile.saveToFile(loggedUser, recipe);
            recipeFile.saveToFile(users);
        } else {
            recipeWrongLabel.setVisible(true);
            recipeWrongLabel.setText("Recipe must be complete to be created");
        }
        recipePrice.setText("");
    }//GEN-LAST:event_createRecipeActionPerformed

    private void logInUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInUserButtonActionPerformed
        //Botones del menú si la sesión se inicia
        String userName = usernameTextArea.getText();
        String password = String.valueOf(passwordField.getPassword());
        if(!(logIn(userName, password))) {
            credentialsWrongLabel.setVisible(true);
        }
    }//GEN-LAST:event_logInUserButtonActionPerformed

    private boolean logIn(String userName, String password) {
        for (User user : users) {
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
                clearLogIn();
                if(user instanceof Client) { 
                    loggedUser = (Client) user;
                    adminRemoveRecipeButton.setVisible(false);
                    cardLayout.show(jPanelCard, "recipeCard");
                }else {
                    loggedUser = (Admin) user;
                    adminRemoveRecipeButton.setVisible(true);
                    cardLayout.show(jPanelCard, "searchRecipesCard");
                }
                setButtonsConfiguration();    
                credentialsWrongLabel.setVisible(false);
                setMyRecipes();
                return true;
            }
        }
        return false;
    }

    private void setButtonsConfiguration() {
        logInButton.setEnabled(false);
        createRecipeButton.setEnabled(true);
        createMenuButton.setEnabled(true);
        searchRecipeButton.setEnabled(true);
        myRecipesButton.setEnabled(true);
        logOutButton.setEnabled(true);
    }

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        loggedUser = null;
        
        //Botones del menú si la sesión se cierra
        logInButton.setEnabled(true);
        createRecipeButton.setEnabled(false);
        createMenuButton.setEnabled(false);
        searchRecipeButton.setEnabled(false);
        myRecipesButton.setEnabled(false);
        logOutButton.setEnabled(false);
        rateOrRemoveButton.setEnabled(false);
        adminRemoveRecipeButton.setEnabled(false);
        ratedMessage.setText("");
        clearModels();
        //Volvemos al panel de iniciar sesión
        cardLayout.show(jPanelCard, "logInCard");
        
        
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void myRecipesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myRecipesButtonActionPerformed
        cardLayout.show(jPanelCard, "myRecipesCard");
        removeRecipeButton.setEnabled(false);
    }//GEN-LAST:event_myRecipesButtonActionPerformed

    private void searchRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRecipeButtonActionPerformed
        initSearchList();
        cardLayout.show(jPanelCard, "searchRecipesCard");
    }//GEN-LAST:event_searchRecipeButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        recipeFoundModel.clear();
        String recipeName = recipeNameToSearch.getText();
        if(((Category) filters.getSelectedItem()) instanceof FinalCategory) {
            FinalCategory filterFC = (FinalCategory) filters.getSelectedItem();
            getRecipesByFilter(recipeName, filterFC);
        } else {
            NotFinalCategory filterNFC = (NotFinalCategory) filters.getSelectedItem();
            getRecipesByFilter(recipeName, filterNFC);
        }
        if(recipesFoundList.isSelectionEmpty()){
            adminRemoveRecipeButton.setEnabled(false);
            rateOrRemoveButton.setEnabled(false);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private User userToRateOrRemove;
    private Recipe recipeToRateOrRemove;
    private void getRecipesByFilter(String recipeName, Category fC) {
        for (User user : users) {
            for (Recipe recipe : user.getRecipes()) {
                if(recipe.getName().contains(recipeName) && recipe.containsCategory(fC.getName())){
                    userToRateOrRemove = user;
                    recipeToRateOrRemove = recipe;
                    this.recipeFoundModel.addElement(user.getUserName() + ": " + recipe);
                }
            }
        }
    }

    private void createMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMenuButtonActionPerformed
        addMenuButton.setEnabled(false);
        myRecipesToAddToMenuModel.clear();
        cardLayout.show(jPanelCard, "menuCard");
        for (Recipe recipe : loggedUser.getRecipes()) {
            myRecipesToAddToMenuModel.addElement(recipe);
        }
    }//GEN-LAST:event_createMenuButtonActionPerformed

    private void addMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenuButtonActionPerformed
        myMenusModel.clear();
        int[] selectedIndices = myRecipesToAddToMenuList.getSelectedIndices();
        if(selectedIndices.length>1) {
            Menu menu = new Menu(menuName.getText());
            for (int selectedIndex : selectedIndices) {
                Recipe recipe = (Recipe) myRecipesToAddToMenuModel.getElementAt(selectedIndex);
                menu.addRecipesToMenu(recipe);
            }
            loggedUser.addMenu(menu);
            myMenusModel.clear();
            for (Menu userMenu : loggedUser.getMenus()) {
                myMenusModel.addElement(userMenu);
            }
        }
        
    }//GEN-LAST:event_addMenuButtonActionPerformed

    private void removeMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMenuButtonActionPerformed
        Menu menuToRemove = (Menu) myMenusModel.getElementAt(myMenusList.getSelectedIndex());
        loggedUser.removeMenu(menuToRemove);
        myMenusModel.clear();
        for (Menu menu : loggedUser.getMenus()) {
            myMenusModel.addElement(menu);
        }
        if(myMenusList.isSelectionEmpty()) removeMenuButton.setEnabled(false);
    }//GEN-LAST:event_removeMenuButtonActionPerformed

    private void resetRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetRecipeActionPerformed
        clearRecipe();
        recipeWrongLabel.setVisible(false);
    }//GEN-LAST:event_resetRecipeActionPerformed

    private void removeRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRecipeButtonActionPerformed
        Recipe recipeToRemove = (Recipe) myRecipesModel.getElementAt(myRecipesList.getSelectedIndex());
        loggedUser.removeRecipe(recipeToRemove);
        myRecipesModel.clear();
        for (Recipe recipe : loggedUser.getRecipes()) {
            myRecipesModel.addElement(recipe);
        }
        recipeFile.saveToFile(users);
        if(myRecipesList.isSelectionEmpty()){
            removeRecipeButton.setEnabled(false);
        }
    }//GEN-LAST:event_removeRecipeButtonActionPerformed

    private void rateRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateRecipeButtonActionPerformed
        
        if(!loggedUser.isMyOwnRecipe(userToRateOrRemove, recipeToRateOrRemove)){
            ratedMessage.setForeground(new java.awt.Color(255, 255, 255));
            ratedMessage.setText("Recipe rated");
            valorationsFile.saveToFile(recipeToRateOrRemove.getName(), userToRateOrRemove.getUserName(),(int) rateValueSpinner.getValue());
        }else{
            ratedMessage.setForeground(new java.awt.Color(255, 0, 0));
            ratedMessage.setText("It is not allowed to rate your own recipe");
        }
    }//GEN-LAST:event_rateRecipeButtonActionPerformed

    private void recipesFoundListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipesFoundListMouseClicked
        if(recipesFoundList.isSelectionEmpty()) {
            rateOrRemoveButton.setEnabled(false);
            adminRemoveRecipeButton.setEnabled(false);
            
        }else {
            rateOrRemoveButton.setEnabled(true);
            adminRemoveRecipeButton.setEnabled(true);
            String userNameSelected = recipesFoundList.getSelectedValue().substring(0,recipesFoundList.getSelectedValue().indexOf(":"));
            String recipeNameSelected = recipesFoundList.getSelectedValue().substring(recipesFoundList.getSelectedValue().indexOf(":")+2,recipesFoundList.getSelectedValue().indexOf(","));
            System.out.println(userNameSelected);
            System.out.println(recipeNameSelected);
            for (User user : users) {
                if(user.getUserName().equals(userNameSelected)) {
                    userToRateOrRemove = user;
                    recipeToRateOrRemove = user.getRecipeByName(recipeNameSelected);
                }
            }
        }
    }//GEN-LAST:event_recipesFoundListMouseClicked

    private void rateOrRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateOrRemoveButtonActionPerformed
        cardLayout.show(jPanelCard, "rateRecipesCard");
        recipeToRateModel.clear();
        recipeToRateModel.addElement(recipeToRateOrRemove);
        selectedRecipeToRateList.setModel(recipeToRateModel);
        cardLayout.show(jPanelCard, "rateRecipesCard");
        
    }//GEN-LAST:event_rateOrRemoveButtonActionPerformed

    private void adminRemoveRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminRemoveRecipeButtonActionPerformed
        ((Admin)loggedUser).removeRecipeOfUser(userToRateOrRemove,recipeToRateOrRemove);
        recipeFile.saveToFile(users);
        recipeFoundModel.clear();
        for (User user : users) {
            for (Recipe recipe : user.getRecipes()) {
                recipeFoundModel.addElement(recipe);
            }
        }
    }//GEN-LAST:event_adminRemoveRecipeButtonActionPerformed

    private void notFinalCategoriesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notFinalCategoriesListMouseClicked
        if(!notFinalCategoriesList.isSelectionEmpty()){
            for (int index: notFinalCategoriesList.getSelectedIndices()) {
                if (selected[index] == 0) {
                    NotFinalCategory notFinalCategory = (NotFinalCategory) notFinalCategoriesModel.getElementAt(index);
                    for (FinalCategory subCategory : notFinalCategory.getSubCategories()) {
                        finalCategoriesModel.addElement(subCategory);
                    }
                    selected[index] = 1;
                }
            }
        }else{
            finalCategoriesModel.clear();
            initSelectedCategories();
        }
    }//GEN-LAST:event_notFinalCategoriesListMouseClicked

    private void ingredientsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingredientsListMouseClicked
        if(!ingredientsList.isSelectionEmpty()){
            int[] selectedIndices = ingredientsList.getSelectedIndices();
            double price = 0.0;
            for (int selectedIndice : selectedIndices) {
                price += ((Ingredient)ingredientsModel.getElementAt(selectedIndice)).getPrice();
            }
            recipePrice.setText(price +"");
        }
    }//GEN-LAST:event_ingredientsListMouseClicked

    private void myMenusListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myMenusListMouseClicked
        if(!myMenusList.isSelectionEmpty()){
            removeMenuButton.setEnabled(true);
        }else removeMenuButton.setEnabled(false);
    }//GEN-LAST:event_myMenusListMouseClicked

    private void myRecipesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myRecipesListMouseClicked
        if(myRecipesList.isSelectionEmpty()) removeRecipeButton.setEnabled(false);
        else removeRecipeButton.setEnabled(true);
    }//GEN-LAST:event_myRecipesListMouseClicked

    private void myRecipesToAddToMenuListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myRecipesToAddToMenuListMouseClicked
        if(myRecipesToAddToMenuList.getSelectedIndices().length>1) addMenuButton.setEnabled(true);
        else addMenuButton.setEnabled(false);
    }//GEN-LAST:event_myRecipesToAddToMenuListMouseClicked

    private void clearRecipe() {
        recipeNameText.setText("");
        stepsTextArea.setText("");
        cookTime.setTime(new Date(0,0,0));
        ingredientsList.clearSelection();
        notFinalCategoriesList.clearSelection();
        finalCategoriesList.clearSelection();
        finalCategoriesModel.clear();
        initSelectedCategories();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMenuButton;
    private javax.swing.JButton adminRemoveRecipeButton;
    private javax.swing.JButton backButton3;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel categoriesFilterSearchLabel;
    private javax.swing.JLabel categoriesLabel;
    private javax.swing.JScrollPane categoriesScrollPane;
    private javax.swing.JScrollPane categoriesScrollPane1;
    private lu.tudor.santec.jtimechooser.JTimeChooser cookTime;
    private javax.swing.JLabel cookTimeLabel;
    private javax.swing.JButton createMenuButton;
    private javax.swing.JPanel createMenuPanel;
    private javax.swing.JLabel createMenuTittleLPanelLabel;
    private javax.swing.JPanel createMenuTittlePanel;
    private javax.swing.JButton createRecipe;
    private javax.swing.JButton createRecipeButton;
    private javax.swing.JLabel credentialsWrongLabel;
    private javax.swing.JComboBox<String> filters;
    private javax.swing.JList<String> finalCategoriesList;
    private javax.swing.JLabel ingredientsLabel;
    private javax.swing.JList<String> ingredientsList;
    private javax.swing.JScrollPane ingredientsScrollPane;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelCard;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPanel;
    private javax.swing.JButton logInButton;
    private javax.swing.JPanel logInPanel;
    private javax.swing.JPanel logInTittlePanel;
    private javax.swing.JPanel logInTittlePanel1;
    private javax.swing.JLabel logInTittlePanelLabel;
    private javax.swing.JLabel logInTittlePanelLabel1;
    private javax.swing.JButton logInUserButton;
    private javax.swing.JButton logOutButton;
    private javax.swing.JTextField menuName;
    private javax.swing.JLabel menusLabel;
    private javax.swing.JList<String> myMenusList;
    private javax.swing.JScrollPane myMenusScrollBar;
    private javax.swing.JButton myRecipesButton;
    private javax.swing.JList<String> myRecipesList;
    private javax.swing.JPanel myRecipesPanel;
    private javax.swing.JScrollPane myRecipesScrollBar;
    private javax.swing.JList<String> myRecipesToAddToMenuList;
    private javax.swing.JScrollPane myRecipesToAddToMenuScrollBar;
    private javax.swing.JLabel nameRecipeLabel;
    private javax.swing.JList<String> notFinalCategoriesList;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel rateErrorLabel;
    private javax.swing.JButton rateOrRemoveButton;
    private javax.swing.JButton rateRecipeButton;
    private javax.swing.JPanel rateRecipesPanel;
    private javax.swing.JPanel rateRecipesTittlePanel;
    private javax.swing.JLabel rateTittleLPanelLabel;
    private javax.swing.JSpinner rateValueSpinner;
    private javax.swing.JLabel ratedMessage;
    private javax.swing.JLabel recipeNameSearchLabel;
    private javax.swing.JTextField recipeNameText;
    private javax.swing.JTextField recipeNameToSearch;
    private javax.swing.JPanel recipePanel;
    private javax.swing.JLabel recipePrice;
    private javax.swing.JPanel recipeTittlePanel;
    private javax.swing.JLabel recipeTittlePanelLabel;
    private javax.swing.JLabel recipeWrongLabel;
    private javax.swing.JScrollPane recipesFoundComboBox;
    private javax.swing.JList<String> recipesFoundList;
    private javax.swing.JLabel recipesLabel;
    private javax.swing.JButton removeMenuButton;
    private javax.swing.JButton removeRecipeButton;
    private javax.swing.JButton resetRecipe;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchRecipeButton;
    private javax.swing.JPanel searchRecipeTittlePanel;
    private javax.swing.JLabel searchTittleLPanelLabel;
    private javax.swing.JPanel searhRecipePanel;
    private javax.swing.JList<String> selectedRecipeToRateList;
    private javax.swing.JLabel stepsLabel;
    private javax.swing.JScrollPane stepsScrollPane;
    private javax.swing.JTextArea stepsTextArea;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextArea;
    // End of variables declaration//GEN-END:variables
}
