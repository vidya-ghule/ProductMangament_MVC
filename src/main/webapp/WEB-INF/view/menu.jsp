<html>
    <head>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">       
     </head>
        <body>
          <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">JBK</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="adduserpage">Add user</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="addproductpage">Add Product</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="userlist"> user List</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="productlist"> product list</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="profile?username=<%=session.getAttribute("username") %>"><%=session.getAttribute("username") %></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Log Out</a>
                </li>
                </ul>
            </div>
          </nav>
          </body>
        </html>