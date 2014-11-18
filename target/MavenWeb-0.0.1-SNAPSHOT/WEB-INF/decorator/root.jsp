<html>  
  <head>  
    <title><sitemesh:write property='title'/>PLM</title>  
    <sitemesh:write property='head'/>  
  </head>  
    
  <body>  
    <div style="color: black">
    <div id="header" style="text-align: right;">
		<ul>
			<li style="list-style: none;"><a href='home'>Home</a>
				| <a href="javascript:closeWindow();">Logout</a></li>
		</ul>
	</div>
	<h1 class="titleClass" style="text-align: center;">${app_name}</h1>
	  
        <sitemesh:write property='body'/>  
        
    </div>  
    
    <div id="footer" class="container">
		<p>PLM System ${year} ${version}</p>
	</div>
  </body>  
    
</html>  