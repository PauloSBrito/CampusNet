class TreeNode:
    def __init__(self, data):
        self.data = data
        self.children = []
        self.parent = None

    def add_child(self, child):
        child.parent = self
        self.children.append(child)

    def get_level(self):
        level = 0
        p = self.parent
        while p:
            level += 1
            p = p.parent
        return level

    def print_tree(self):
        spaces = ' ' * self.get_level() * 3
        prefix = spaces + "|__" if self.parent else ""
        print(prefix + self.data)
        #print(self.data)
        if self.children:
            for child in self.children:
                child.print_tree()

def build_product_tree():
    root = TreeNode("Electronics")

    laptop = TreeNode("Laptop")
    laptop.add_child(TreeNode("MAC"))
    laptop.add_child(TreeNode("Thinkpad"))
    laptop.add_child(TreeNode("Positivo"))

    cellphone = TreeNode("Cellphone")
    cellphone.add_child(TreeNode("IPHONE"))
    cellphone.add_child(TreeNode("IOS"))
    cellphone.add_child(TreeNode("android"))

    tv = TreeNode("TV")
    tv.add_child(TreeNode("Samsung"))
    tv.add_child(TreeNode("POSITIVO"))
    tv.add_child(TreeNode("SMART"))

    root.add_child(laptop)
    root.add_child(cellphone)
    root.add_child(tv)
    #print(tv.get_level())
    return root

class Exercise(TreeNode):
    def __init__(self, data, designation):
        super().__init__(data)
        self.designation = designation

    def add_child_exercise(self, child, designation):
        child.parent = self
        self.children.append(child, designation)

    def print_exercise_tree(self):
        spaces = ' ' * self.get_level() * 3
        prefix = spaces + "|__" if self.parent else ""
        print(prefix + self.data + "(" + self.designation + ")")
        if self.children:
            for child in self.children:
                child.print_exercise_tree()

    def print_exercise_tree_name(self):
        spaces = ' ' * self.get_level() * 3
        prefix = spaces + "|__" if self.parent else ""
        print(prefix + self.data)
        if self.children:
            for child in self.children:
                child.print_exercise_tree_name()

    def print_exercise_tree_designation(self):
        spaces = ' ' * self.get_level() * 3
        prefix = spaces + "|__" if self.parent else ""
        print(prefix + self.designation)
        if self.children:
            for child in self.children:
                child.print_exercise_tree_designation()

def build_exercise_tree():
    ceo = Exercise("Nilupul", "CEO")

    cto = Exercise("Chinmay", "CTO")
    ceo.add_child(cto)
    infra_head = Exercise("Vishwa", "Infrastructure Head")
    cto.add_child(infra_head)
    infra_head.add_child(Exercise("Dhaval", "Cloud Manager"))
    infra_head.add_child(Exercise("Abhjit", "App Manager"))
    app_head = Exercise("Aamir", "Application Head")
    cto.add_child(app_head)

    hr_head = Exercise("Gels", "HR Head")
    ceo.add_child(hr_head)
    hr_head.add_child(Exercise("Peter", "Recruit Manager"))
    hr_head.add_child(Exercise("Waqas", "Policy Manager"))

    return ceo

if __name__ == '__main__':
    ceo = build_exercise_tree()
    ceo.print_exercise_tree_designation()
    #print(root.get_level())
    pass
