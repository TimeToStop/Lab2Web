
document.addEventListener('DOMContentLoaded', function(event) 
{
    let canvas = document.getElementById('canvas');

    canvas.addEventListener('click', function(event) 
    {
        let rect = event.target.getBoundingClientRect();
        let point = toXOY(event.x - rect.left, event.y - rect.top);
        console.log(point);
        checkHit(point);
    });
});

function checkHit(point) 
{    
    $.post('index', { X : point._x , Y : point._y, R : global_radius, PIC : true}, 
    function(data) {
        drawPoint(point._x, point._y, JSON.parse(data).hit);
    });
}

