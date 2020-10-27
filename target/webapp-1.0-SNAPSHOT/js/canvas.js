const w = 300;
const h = 300;
const r = 80;

const ox = w / 2;
const oy = h / 2;

var global_radius = 1;

document.addEventListener('DOMContentLoaded', function(event) 
{
    let canvas = document.getElementById('canvas');
    canvas.width = w;
    canvas.height = h;

    let rs = document.getElementsByClassName('r-radio');

    for (let r of rs)
    {
        r.addEventListener('click', function(event)
        {
            draw(event.target.value);
        });
    }

    let reset = document.getElementById('reset');

    reset.addEventListener('click', function(event) 
    {
        let buttons = document.getElementsByClassName('y-button');
        let y = document.getElementById('Y');
        y.value = '';
    
        for(let _button of buttons)
        {
            _button.style.background = '#d4d4d4';
        }
        
        draw(1);
    });

    let buttons = document.getElementsByClassName('y-button');
    for(let _button of buttons)
    {
        _button.style.background = '#d4d4d4';
    }

    draw(1);
});

function toXOY(x, y)
{
    return {
        _x : global_radius * (x - ox)/r,
        _y : global_radius * (-y + oy)/r
    }
}

function drawPoint(x, y, hit)
{
    let ctx  = document.getElementById('canvas').getContext('2d');
    ctx.fillStyle = hit ? '#00FF00' : '#FF0000';

    let f_x = ox + x * (r / global_radius);
    let f_y = oy - y * (r / global_radius);

    ctx.beginPath();
    ctx.arc(f_x, f_y, 3, 0, 2 * Math.PI, true);
    ctx.closePath();
    ctx.fill();
}

function draw(radius)
{
    global_radius = radius;
    let r_name = radius.toString(), r_half_name = (radius/2).toString();
    let canvas = document.getElementById('canvas');

    if(canvas && canvas.getContext)
    {
        let ctx = canvas.getContext('2d'); 

        ctx.fillStyle = '#FFFFFF';
        ctx.fillRect(0, 0, w, h);

        // draw main figure
        ctx.fillStyle = '#3399FF';
        
        ctx.beginPath();
        ctx.moveTo(ox, oy);
        ctx.lineTo(ox, oy - r);
        ctx.lineTo(ox + r, oy);
        ctx.lineTo(ox + r, oy + r);
        ctx.lineTo(ox, oy + r);
        ctx.lineTo(ox, oy + r/2);
        ctx.moveTo(ox, oy);
        ctx.arc(ox ,oy, r /2, Math.PI /2, -Math.PI, false);
        ctx.moveTo(ox - r/2, oy);
        ctx.lineTo(ox, oy);
        ctx.closePath();
        ctx.fill();

        // Draw arrows
        ctx.beginPath();
        canvas_arrow(ctx, ox - 5 * r/3, oy, ox  + 5 * r/3, oy);
        ctx.closePath();
        ctx.stroke();

        ctx.beginPath();
        canvas_arrow(ctx, ox, oy + 5 * r/3, ox, oy - 5 * r/3);
        ctx.closePath();
        ctx.stroke();

        // draw Text
        const d = 5;
        ctx.fillStyle = '#000000';
        ctx.font = '12px sans-serif';

        ctx.fillText(r_name, ox + r, oy - d);
        ctx.fillText('-' + r_name, ox - r, oy - d);
        ctx.fillText(r_name, ox + d, oy - r);
        ctx.fillText('-' + r_name, ox + d, oy + r);

        ctx.fillText(r_half_name, ox + r / 2, oy - d);
        ctx.fillText('-' + r_half_name, ox - r / 2, oy - d);
        ctx.fillText('-' + r_half_name, ox + d, oy + r / 2);
        ctx.fillText(r_half_name, ox + d, oy - r / 2);

        ctx.fillText('X', ox  + 5 * r/3, oy - d);
        ctx.fillText('Y', ox + d, oy - 5 * r/3 + d);
    }
}

function canvas_arrow(context, fromx, fromy, tox, toy)
{
    let headlen = 10;
    let dx = tox - fromx;
    let dy = toy - fromy;
    let angle = Math.atan2(dy, dx);
    context.moveTo(fromx, fromy);
    context.lineTo(tox, toy);
    context.lineTo(tox - headlen * Math.cos(angle - Math.PI / 6), toy - headlen * Math.sin(angle - Math.PI / 6));
    context.moveTo(tox, toy);
    context.lineTo(tox - headlen * Math.cos(angle + Math.PI / 6), toy - headlen * Math.sin(angle + Math.PI / 6));
}
