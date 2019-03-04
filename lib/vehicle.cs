using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Douglas_car_rental_server
{
    #region Vehicle
    public class Vehicle
    {
        #region Member Variables
        protected int _id;
        protected string _Make;
        protected string _Model;
        protected string _Year;
        protected string _Type;
        #endregion
        #region Constructors
        public Vehicle() { }
        public Vehicle(string Make, string Model, string Year, string Type)
        {
            this._Make=Make;
            this._Model=Model;
            this._Year=Year;
            this._Type=Type;
        }
        #endregion
        #region Public Properties
        public virtual int Id
        {
            get {return _id;}
            set {_id=value;}
        }
        public virtual string Make
        {
            get {return _Make;}
            set {_Make=value;}
        }
        public virtual string Model
        {
            get {return _Model;}
            set {_Model=value;}
        }
        public virtual string Year
        {
            get {return _Year;}
            set {_Year=value;}
        }
        public virtual string Type
        {
            get {return _Type;}
            set {_Type=value;}
        }
        #endregion
    }
    #endregion
}