import React from 'react';
import './register.css';

export const FormError = ({formErrors}) => <div>
    {Object.keys(formErrors).map((fieldName,i) => {
        if(formErrors[fieldName].length>0){
            return (<p key = {i} className = 'error'>{fieldName.toUpperCase()} {formErrors[fieldName]}</p>)
        }
        else{
            return "";
        }
    })}
</div>