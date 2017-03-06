/**
 * functions for search items
 */
function searchFunction() {
    var input, filter, ul, li, a, i, counter=0;
    input = document.getElementById("search-input");
    filter = input.value.toUpperCase();
    ul = document.getElementById("search-items-list");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
            counter++;
        } else {
            li[i].style.display = "none";
        }
    }
    document.getElementById("nr").innerHTML = counter;
}