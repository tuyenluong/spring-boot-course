## What replace function in Thymeleaf does?

- The replace function in Thymeleaf is used to dynamically include or substitute one HTML fragment (or a whole template) inside another template. It is commonly used for modularizing templates by reusing pieces of HTML (such as headers, footers, or menus) across different pages.\

## How replace Works

The replace function completely replaces the content of the current HTML element with the content of another template or fragment.

### Syntax
```html
<div th:replace="templateName :: fragmentName"></div>
```
- templateName: The name of the template file (without the .html extension).
- :: fragmentName: The specific fragment within the template to replace the current element. If omitted, the entire template will be included.

## Use Cases

1. **Reusable Components** (e.g., Header/Footer):
   1. `common/header` refers to the header fragment in common.html.
   2. `common/footer` refers to the footer fragment in common.html.
```html
<!-- Including a header fragment -->
<header th:replace="common/header :: header"></header>

<!-- Including a footer fragment -->
<footer th:replace="common/footer :: footer"></footer>
```
2. **Modular Layouts**: You can use replace to assemble a layout by combining multiple fragments:
```html
<html>
    <head th:replace="common/head :: head"></head>
    <body>
        <div th:replace="common/sidebar :: sidebar"></div>
        <div th:replace="common/content :: content"></div>
    </body>
</html>
```
3. **Dynamic Content Replacement**: Replace the current element's content based on a condition or dynamically provided fragment:
```html
<div th:replace="${dynamicTemplate} :: dynamicFragment"></div>
```

## Fragment Example

- In common.html:
```html
<!-- Header Fragment -->
<div th:fragment="header">
    <h1>My Website Header</h1>
</div>

<!-- Footer Fragment -->
<div th:fragment="footer">
    <p>© 2025 My Website</p>
</div>
```

- In Your Main Template:
```html
<html>
<body>
    <header th:replace="common :: header"></header>
    <footer th:replace="common :: footer"></footer>
</body>
</html>
```

## Key Features
1. Scoping Variables: When replacing content, you can pass variables to the fragment:
   1. Inside the fragment, the passed variables are available for use.
```html
<div th:replace="common :: fragmentName(${var1}, ${var2})"></div>
```
2. **Complete Replacement**: The entire <div> tag (or whatever element is used) is replaced, not just its contents.

## Difference Between replace and include
- th:replace: Completely replaces the element, including the tag itself. 
- th:include: Includes the fragment within the current element (leaving the tag intact).

### Example:
For the same fragment header:
- Using replace:
  - The \<header> tag is replaced with the fragment's content.
```html
<header th:replace="common :: header"></header>
```
- Using include:
  - The \<header> tag remains, and the fragment's content is inserted inside it.
```html
<header th:include="common :: header"></header>
```