
function validate()
{
    let error = document.getElementById('error');

    let x = document.getElementById('X');
    let y = document.getElementById('Y');

    let str_x = x.value.replace(',', '.');
    let str_y = y.value;
    let value_x = Number(str_x);

    if(str_x == '')
    {
        error.innerHTML = 'X не задано';
        return false;
    }
    else if(isNaN(value_x))
    {
        error.innerHTML = 'X не число';
        return false;
    }
    else
    {
        if(str_x.length > 5)
        {
            str_x = str_x.slice(0, 5);
            str_x = ''.concat(str_x, '1');
        }

        value_x = Number(str_x);

        if(value_x < -5 || value_x > 5)
        {
            error.innerHTML = 'X не входит в интервал (-5, 5)';
            return false;
        }
    }

    if(str_y == '')
    {
        error.innerHTML = 'Y не задан';
        return false;
    }

    error.innerHTML = '';
    return true;
}

function validateY(button)
{
    let buttons = document.getElementsByClassName('y-button');
    let y = document.getElementById('Y');
    y.value = button.value;

    for(let _button of buttons)
    {
        _button.style.background = '#d4d4d4';
    }

    button.style.background = '#00FF00';
}

